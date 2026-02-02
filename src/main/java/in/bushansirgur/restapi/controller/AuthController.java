package in.bushansirgur.restapi.controller;

import in.bushansirgur.restapi.dto.ProfileDTO;
import in.bushansirgur.restapi.io.AuthRequest;
import in.bushansirgur.restapi.io.AuthResponse;
import in.bushansirgur.restapi.io.ProfileRequest;
import in.bushansirgur.restapi.io.ProfileResponse;
import in.bushansirgur.restapi.service.CustomUserDetailService;
import in.bushansirgur.restapi.service.ProfileService;
import in.bushansirgur.restapi.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final ModelMapper modelMapper;
    private final ProfileService profileService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final CustomUserDetailService userDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public ProfileResponse createProfile(@RequestBody ProfileRequest profileRequest) {
        log.info("API /register is called {}", profileRequest);
        ProfileDTO profileDTO = mapToProfileDTO(profileRequest);
        profileDTO = profileService.createProfile(profileDTO);
        return mapToProfileResponse(profileDTO);
    }

    @PostMapping("/login")
    public AuthResponse authenticateProfile(@RequestBody AuthRequest authRequest) {
        log.info("API /login is called {}", authRequest);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new AuthResponse(UUID.randomUUID().toString(), authRequest.getEmail());

    }

    private ProfileDTO mapToProfileDTO(ProfileRequest profileRequest) {
        return modelMapper.map(profileRequest, ProfileDTO.class);
    }

    private ProfileResponse mapToProfileResponse(ProfileRequest profileRequest) {
        return modelMapper.map(profileRequest, ProfileResponse.class);
    }
}

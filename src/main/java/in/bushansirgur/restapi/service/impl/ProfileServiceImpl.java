package in.bushansirgur.restapi.service.impl;

import in.bushansirgur.restapi.dto.ProfileDTO;
import in.bushansirgur.restapi.entity.ProfileEntity;
import in.bushansirgur.restapi.exceptions.ItemExistsException;
import in.bushansirgur.restapi.repository.ProfileRepository;
import in.bushansirgur.restapi.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        if (profileRepository.existByEmail(profileDTO.getEmail())) {
            throw new ItemExistsException("Profile already exists" + profileDTO.getEmail());
        }
        profileDTO.setPassword(encoder.encode(profileDTO.getPassword()));
        ProfileEntity profileEntity = mapToProfileEntity(profileDTO);
        profileEntity.setProfileId(UUID.randomUUID().toString());

        profileEntity = profileRepository.save(profileEntity);
        return mapToProfileDTO(profileEntity);
    }

    private ProfileDTO mapToProfileDTO(ProfileEntity profileEntity) {
        return modelMapper.map(profileEntity, ProfileDTO.class);
    }


    private ProfileEntity mapToProfileEntity(ProfileDTO profileDTO) {
        modelMapper.map()
    }
}

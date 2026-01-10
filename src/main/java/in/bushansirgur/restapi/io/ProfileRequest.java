package in.bushansirgur.restapi.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {
    @NotBlank(message = "Name is required")
    @Sized(min = 3, message = "Password should be at least 3 characters")
    private String name;


    @NotNull(message = "Email is required")
    @Email(message = "Provide valid email address")
    private String email;


    @NotNull(message = "Password is required")
    @Sized(min = 5, message = "Password should be at least 5 characters")
    private String password;
}

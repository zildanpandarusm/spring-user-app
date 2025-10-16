package spring.userapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {

    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @Size(max = 50, message = "Username must be less than 50 characters")
    private String username;

    @Email(message = "Email must be valid")
    private String email;

    @Size(max = 100, message = "Address must be less than 100 characters")
    private String address;
}

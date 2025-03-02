package dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}

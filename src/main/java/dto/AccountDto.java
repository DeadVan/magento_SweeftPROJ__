package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

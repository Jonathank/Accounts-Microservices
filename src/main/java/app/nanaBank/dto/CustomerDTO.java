package app.nanaBank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CustomerDTO {
    @NotEmpty(message = "Customer name cannot be empty")
    @Size(min = 5, max = 30, message = "Customer name must be between 5 and 30 characters")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Customer mobileNumber cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    private AccountsDTO accountsDetails;
}

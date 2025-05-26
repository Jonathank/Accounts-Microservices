package app.nanaBank.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = "accountNumber cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number must be 10 digits")
    private Long accountNumber;
    @NotEmpty(message = "accountName cannot be empty")
    private String accountName;
    @NotEmpty(message = "accountType cannot be empty")
    private String accountType;
    @NotEmpty(message = "accountStatus cannot be empty")
    private String accountStatus;
    @NotEmpty(message = "branchName cannot be empty")
    private String branchName;
    @NotEmpty(message = "branchAddress cannot be empty")
    private String branchAddress;
}

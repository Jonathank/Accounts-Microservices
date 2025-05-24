package app.nanaBank.dto;

import lombok.Data;

@Data
public class AccountsDTO {

    private Long accountNumber;
    private String accountName;
    private String accountType;
    private String accountStatus;
    private String branchName;
    private String branchAddress;
}

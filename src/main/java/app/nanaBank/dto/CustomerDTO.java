package app.nanaBank.dto;

import lombok.Data;
@Data
public class CustomerDTO {
    
    private String name;
    private String email;
    private String phoneNumber;
    private AccountsDTO accountsDetails;
}

package app.nanaBank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.nanaBank.constants.AccountsConstants;
import app.nanaBank.dto.CustomerDTO;
import app.nanaBank.responsedto.ResponseDTPO;
import app.nanaBank.services.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/accounts", produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
public class AccountController {

    private final IAccountService accountService;
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDTPO>createAccount(
	   @Valid @RequestBody CustomerDTO customerDTO
	    ) {
	accountService.createAccount(customerDTO);
	return ResponseEntity.status(HttpStatus.CREATED).body(
	    new ResponseDTPO(AccountsConstants.STATUS_CODE_CREATED,
		    AccountsConstants.Message_201));
    }
    
    @GetMapping("/fetch/AccountDetails")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(
	    @RequestParam
	    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	    String phoneNumber) {
	CustomerDTO customerDTO = accountService.fetchAccountDetails(phoneNumber);
	
	return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }
    
    @PutMapping("/update")
    public ResponseEntity<ResponseDTPO> updateAccountDetails(
	    @Valid@RequestBody CustomerDTO customerDTO) {
	boolean isUpdated = accountService.updateAccountDetails(customerDTO);
	if (isUpdated) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_SUCCESS,
			    AccountsConstants.ACCOUNT_UPDATE_SUCCESSFUL));	
	} else {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_FAILURE,
			    AccountsConstants.Message_500));
	    
	}
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTPO> deleteAccount(
	    @RequestParam 
	    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	    String phoneNumber) {
	boolean isDeleted = accountService.deleteAccount(phoneNumber);
	if (isDeleted) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_SUCCESS,
			    AccountsConstants.ACCOUNT_DELETED_SUCCESSFULLY));
	    } else {
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_FAILURE,
			    AccountsConstants.Message_500));
			    
	    }
    }
}

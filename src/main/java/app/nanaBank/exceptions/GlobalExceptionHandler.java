/**
 * 
 */
package app.nanaBank.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import app.nanaBank.responsedto.ErrorResponseDTO;

/**
 * @author JONATHAN
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles CustomerAlreadyExistException and returns a custom error response.
     *
     * @param ex the exception that was thrown
     * @param webRequest the current web request
     * @return a ResponseEntity containing the error response
     */
    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(
	    CustomerAlreadyExistException ex,
	    WebRequest webRequest) {
	ErrorResponseDTO errorResponse = new ErrorResponseDTO(
		webRequest.getDescription(false),
		HttpStatus.BAD_REQUEST,
		ex.getMessage(),
		LocalDateTime.now()
		);
	
	return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(
	    ResourceNotFoundException ex,
	    WebRequest webRequest) {
	ErrorResponseDTO errorResponse = new ErrorResponseDTO(
		webRequest.getDescription(false),
		HttpStatus.NOT_FOUND,
		ex.getMessage(),
		LocalDateTime.now()
		);
	return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

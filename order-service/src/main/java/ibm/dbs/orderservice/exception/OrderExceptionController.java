package ibm.dbs.orderservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ControllerAdvice

public class OrderExceptionController {


	   @ExceptionHandler(value = OrderNotFoundException.class)
	   public ResponseEntity<Object> exception(OrderNotFoundException exception) {
	      return new ResponseEntity<>("Order Not Found", HttpStatus.NOT_FOUND);
	   }
	   
	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public Map<String, String> inputValidation(
	     MethodArgumentNotValidException ex) {
	       Map<String, String> errors = new HashMap<>();
	       ex.getBindingResult().getAllErrors().forEach((error) -> {
	           String fieldName = ((FieldError) error).getField();
	           String errorMessage = error.getDefaultMessage();
	           errors.put(fieldName, errorMessage);
	       });
	       return errors;
	   }
}

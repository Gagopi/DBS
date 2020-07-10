package ibm.dbs.orderitemservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice

public class OrderItemExceptionController {


	   @ExceptionHandler(value = OrderItemNotFoundException.class)
	   public ResponseEntity<Object> exception(OrderItemNotFoundException exception) {
	      return new ResponseEntity<>("Order Item Not Found", HttpStatus.NOT_FOUND);
	   }
}

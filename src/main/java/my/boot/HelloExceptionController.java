package my.boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HelloExceptionController{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity helloException(Exception exp) {
		return new ResponseEntity(exp, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
}

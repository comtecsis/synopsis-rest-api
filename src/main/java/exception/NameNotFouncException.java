package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NameNotFouncException extends RuntimeException {
	
	public NameNotFouncException(String name) {
		super(String.format("code: ERROR code: ERROR-0001,\n"
				+ "message: "+ name +" no encontrado"));
	}
}

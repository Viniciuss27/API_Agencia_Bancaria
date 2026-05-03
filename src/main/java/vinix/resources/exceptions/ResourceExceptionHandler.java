package vinix.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import vinix.services.exceptions.IntegerException;
import vinix.services.exceptions.StringException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(IntegerException.class)//trata excessão do Integer
	public ResponseEntity<StandardError> resorceNotFound(IntegerException e, HttpServletRequest request){
		String error = "Erro com Integer";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError( error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(StringException.class)//trata excessão da String
	public ResponseEntity<StandardError> database(StringException e, HttpServletRequest request){
		String error = "Erro com String";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError( error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
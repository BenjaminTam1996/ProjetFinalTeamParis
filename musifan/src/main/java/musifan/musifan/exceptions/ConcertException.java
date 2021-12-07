package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees du concert incorrectes")
public class ConcertException extends RuntimeException{
	
	public ConcertException() {
		
	}
	
	public ConcertException(String message) {
		super(message);
	}
}

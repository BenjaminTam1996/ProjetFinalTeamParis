package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees de l'artiste incorrectes")
public class ArtisteException extends RuntimeException {

	public ArtisteException() {
		
	}
	
	public ArtisteException(String message) {
		super(message);
	}
	
}

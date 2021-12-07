package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees de la commande incorrectes")
public class CommandeException extends RuntimeException {
	public CommandeException() {

	}

	public CommandeException(String message) {
		super(message);
	}
	
	
}

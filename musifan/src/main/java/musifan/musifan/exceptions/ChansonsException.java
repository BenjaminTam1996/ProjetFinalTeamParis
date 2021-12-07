package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees de la chanson incorrectes")
public class ChansonsException extends RuntimeException {
	
	public ChansonsException() {

	}

	public ChansonsException(String message) {
		super(message);
	}

}

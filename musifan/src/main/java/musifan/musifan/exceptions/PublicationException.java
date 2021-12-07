package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees de la publication incorrectes")
public class PublicationException extends RuntimeException {
	public PublicationException() {

	}

	public PublicationException(String message) {
		super(message);
	}

}

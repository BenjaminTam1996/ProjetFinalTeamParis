package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees de l'album incorrectes")
public class AlbumException extends RuntimeException {
	
		public AlbumException() {

		}

		public AlbumException(String message) {
			super(message);
		}
}

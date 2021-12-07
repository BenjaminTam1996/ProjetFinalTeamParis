package musifan.musifan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, value=HttpStatus.BAD_REQUEST, reason = "donnees du lieu incorrectes")
public class LieuException extends RuntimeException{
	
	public LieuException() {
		
	}
	
	public LieuException(String message) {
		super(message);
	}
}

package musifan.musifan.exceptions;

public class ConcertException extends RuntimeException{
	
	public ConcertException() {
		
	}
	
	public ConcertException(String message) {
		super(message);
	}
}

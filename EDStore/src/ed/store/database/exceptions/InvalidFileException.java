package ed.store.database.exceptions;

@SuppressWarnings("serial")
public class InvalidFileException extends RuntimeException {

	public InvalidFileException() {
		super();
	}
	
	public InvalidFileException(String log) {
		super(log);
	}
	
	public InvalidFileException(Exception e) {
		super(e);
	}
	
}

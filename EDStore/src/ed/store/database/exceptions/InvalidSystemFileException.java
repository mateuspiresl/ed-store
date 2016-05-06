package ed.store.database.exceptions;

public class InvalidSystemFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidSystemFileException(String log) {
		super(log);
	}
	
}

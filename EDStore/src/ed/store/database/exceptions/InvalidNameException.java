package ed.store.database.exceptions;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNameException(String log) {
		super(log);
	}
	
}
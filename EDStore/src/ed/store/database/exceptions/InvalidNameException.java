package ed.store.database.exceptions;

@SuppressWarnings("serial")
public class InvalidNameException extends Exception {

	public InvalidNameException() {
		super();
	}
	
	public InvalidNameException(String log) {
		super(log);
	}
	
	public InvalidNameException(Exception e) {
		super(e);
	}
	
}
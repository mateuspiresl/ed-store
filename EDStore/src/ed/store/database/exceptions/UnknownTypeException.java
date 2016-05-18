package ed.store.database.exceptions;

public class UnknownTypeException extends RuntimeException {

	public UnknownTypeException() {
		super();
	}
	
	public UnknownTypeException(String log) {
		super(log);
	}
	
	public UnknownTypeException(Exception e) {
		super(e);
	}
	
}

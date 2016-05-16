package ed.store.database.exceptions;

public class UnknownTypeException extends Exception {

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

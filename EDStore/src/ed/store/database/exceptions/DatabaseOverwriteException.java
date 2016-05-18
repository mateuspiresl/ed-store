package ed.store.database.exceptions;

public class DatabaseOverwriteException extends Exception {

	public DatabaseOverwriteException() {
		super();
	}
	
	public DatabaseOverwriteException(String log) {
		super(log);
	}
	
	public DatabaseOverwriteException(Exception e) {
		super(e);
	}
	
}

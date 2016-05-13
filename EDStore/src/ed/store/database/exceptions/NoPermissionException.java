package ed.store.database.exceptions;

@SuppressWarnings("serial")
public class NoPermissionException extends Exception {

	public NoPermissionException() {
		super();
	}
	
	public NoPermissionException(String log) {
		super(log);
	}
	
	public NoPermissionException(Exception e) {
		super(e);
	}
	
}

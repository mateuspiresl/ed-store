package ed.store.database.exceptions;

@SuppressWarnings("serial")
public class CorruptedFileException extends RuntimeException {

	public CorruptedFileException() {
		super();
	}
	
	public CorruptedFileException(String log) {
		super(log);
	}
	
	public CorruptedFileException(Exception e) {
		super(e);
	}
	
}

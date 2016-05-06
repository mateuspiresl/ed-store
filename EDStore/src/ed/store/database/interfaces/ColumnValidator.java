package ed.store.database.interfaces;

public interface ColumnValidator<T> {

	public boolean validate(T data);

}
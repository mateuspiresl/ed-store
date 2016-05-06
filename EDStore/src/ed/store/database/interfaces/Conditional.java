package ed.store.database.interfaces;

public interface Conditional<T> {

	public boolean check(T data);

}
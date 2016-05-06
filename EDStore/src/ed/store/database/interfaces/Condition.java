package ed.store.database.interfaces;

public interface Condition<T> {

	public boolean check(T data);

}
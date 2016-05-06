package ed.store.database;

public interface Condition<T> {

	public boolean check(T data);

}
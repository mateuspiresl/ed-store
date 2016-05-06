package ed.store.database.interfaces;

public interface Relational<T> {

	public boolean check(T data, T rel);

}
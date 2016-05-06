package ed.store.database.interfaces;

public interface Relation<T> {

	public boolean check(T data, T rel);

}
package ed.store.database;

public interface Relation<T> {

	public boolean check(T data, T rel);

}
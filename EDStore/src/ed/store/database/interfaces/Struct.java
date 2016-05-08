package ed.store.database.interfaces;

public interface Struct<T> extends Modifiable {

	public int size();
	public boolean isEmpty();
	public void clear();

}
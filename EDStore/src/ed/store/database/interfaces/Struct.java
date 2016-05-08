package ed.store.database.interfaces;

public interface Struct<T> extends Modifiable {
	
	@Override
	public boolean wasModified();

	public int size();
	public boolean isEmpty();
	public void clear();

}
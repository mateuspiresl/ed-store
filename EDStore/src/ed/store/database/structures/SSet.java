package ed.store.database.structures;

import java.io.Serializable;

import ed.store.database.Entry;
import ed.store.database.interfaces.List;
import ed.store.database.interfaces.Set;

public class SSet<T> implements Set<String>, Serializable {

	private static final int HASH_LIMIT = 1024;
	
	private List<Entry<K, V>>[] table = new SList[HASH_LIMIT];
	private int size = 0;
	
	public SSet() {
		// TODO
	}
	
	public SSet(SSet<T> set) {
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean has(String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(String data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] toArray(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}

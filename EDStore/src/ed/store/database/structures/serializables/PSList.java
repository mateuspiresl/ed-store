package ed.store.database.structures.serializables;

import java.io.Serializable;

import ed.store.database.interfaces.Modifiable;
import ed.store.database.structures.SList;

public class PSList<T extends Serializable> extends SList<T> implements Modifiable {

	private transient boolean modifiedFlag = false;
	
	public PSList() { super(); }
	public PSList(SList<T> list) { super(list); }
	
	@Override
	public boolean wasModified() {
		return this.modifiedFlag;
	}
	
	@Override
	public void notifyChanges() {
		this.modifiedFlag = true;
	}
	
	@Override
	public void notifySaving() {
		this.modifiedFlag = false;
	}
	
	@Override
	public synchronized void clear() {
		notifyChanges();
		super.clear();
	}

	@Override
	public synchronized int add(T data) {
		notifyChanges();
		return super.add(data);
	}
	
	@Override
	public void addAll(T[] data) {
		notifyChanges();
		super.addAll(data);
	}

	@Override
	public synchronized void insert(T data, int index) {
		notifyChanges();
		super.insert(data, index);
	}
	
	@Override
	public void insertAll(T[] data, int index) {
		notifyChanges();
		super.insertAll(data, index);
	}

	@Override
	public synchronized void set(int index, T data) {
		notifyChanges();
		super.set(index, data);
	}

	@Override
	public int set(T curr, T data) {
		notifyChanges();
		return super.set(curr, data);
	}

	@Override
	public int[] setAll(T curr, T data) {
		notifyChanges();
		return super.setAll(curr, data);
	}

	@Override
	public T remove(int index) {
		notifyChanges();
		return super.remove(index);
	}

	@Override
	public int remove(T data) {
		notifyChanges();
		return super.remove(data);
	}

	@Override
	public T[] removeAll(T data) {
		notifyChanges();
		return super.removeAll(data);
	}
	
}

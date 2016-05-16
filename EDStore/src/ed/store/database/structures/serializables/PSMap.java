package ed.store.database.structures.serializables;

import java.io.Serializable;

import ed.store.database.interfaces.Map;
import ed.store.database.interfaces.Modifiable;
import ed.store.database.structures.SMap;

public class PSMap<K extends Serializable, V extends Serializable> extends SMap<K, V>implements Modifiable {

	private transient boolean modifiedFlag = false;
	
	@Override
	public boolean wasModified() {
		return this.modifiedFlag;
	}

	@Override
	public void notifyChanges() {
		this.modifiedFlag = true;
	}
	
	@Override
	public synchronized void notifySaving() {
		this.modifiedFlag = false;
	}
	
	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}

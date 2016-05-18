package ed.store.database;

import java.io.Serializable;

public class Entry<K, V> implements Serializable {
	
	public final K key;
	public V value;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
}

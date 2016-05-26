package ed.store.database.interfaces;

import java.io.Serializable;

import ed.store.database.Entry;
import ed.store.database.enums.Conditions;

public interface Map<K extends Serializable, V extends Serializable> extends Struct {

	public boolean hasKey(K key);
	public boolean hasValue(V value);
	
	public void put(K key, V value);
	public void putAll(Map<? extends K, ? extends V> map);
	
	public V get(K key);
	public V remove(K key);
	
	public List<K> getKeys();
	public List<K> getKeys(Conditions condition, K rel);
	public List<V> getValues();
	public List<V> getValues(Conditions condition, V rel);
	public List<Entry<? extends K, ? extends V>> getEntries(); 
	public List<Entry<? extends K, ? extends V>> getEntries(Conditions condition, K rel);

}
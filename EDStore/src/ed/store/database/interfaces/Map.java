package ed.store.database.interfaces;

public interface Map<K, V> extends Struct {

	public boolean hasKey(K key);
	public boolean hasValue(V value);
	
	public void put(K key, V value);
	public void putAll(Map<? extends K, ? extends V> map);
	
	public V get(K key);
	public V remove(K key);
	
	public K[] getKeys();
	public V[] getValues();

}
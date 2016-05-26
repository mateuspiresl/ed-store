package ed.store.database.structures;

import java.io.Serializable;

import ed.store.database.Entry;
import ed.store.database.enums.Conditions;
import ed.store.database.interfaces.List;
import ed.store.database.interfaces.Map;
import ed.store.database.structures.serializables.PSList;

@SuppressWarnings("unchecked")
public class SMap<K extends Serializable & Comparable<? super K>, V extends Serializable & Comparable<? super V>>
		implements Map<K, V>, Serializable {

	private static final int HASH_LIMIT = 1024;
	
	private List<Entry<K, V>>[] table = new SList[HASH_LIMIT];
	private int size = 0;
	
	public SMap() { }
	
	public SMap(SMap<? extends K, ? extends V> map)
	{
		for (Entry<? extends K, ? extends V> entry : map.getEntries())
			put(entry.key, entry.value);
	}
	
	private int getKeyHash(K key) {
		return Math.abs(key.hashCode()) % HASH_LIMIT;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clear()
	{
		for (List<Entry<K, V>> list : this.table)
			list.clear();
	}

	@Override
	public boolean hasKey(K key) {
		return get(key) != null;
	}

	@Override
	public boolean hasValue(V value)
	{
		for (List<Entry<K, V>> list : this.table)
			if (list != null)
				for (Entry<K, V> entry : list)
					if (entry.value.equals(value))
						return true;
		
		return false;
	}

	@Override
	public void put(K key, V value)
	{
		int hashCode = getKeyHash(key);
		
		if (this.table[hashCode] == null)
			this.table[hashCode] = new SList<Entry<K, V>>();
		
		List<Entry<K, V>> list = this.table[hashCode];
		
		for (Entry<K, V> entry : list) {
			if (entry.key.equals(key))
			{
				entry.value = value;
				return;
			}
		}
		
		list.add(new Entry<K, V>(key, value));
		this.size++;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map)
	{
		for (Entry<? extends K, ? extends V> entry : map.getEntries())
			put(entry.key, entry.value);
	}

	@Override
	public V get(K key)
	{
		List<Entry<K, V>> list = this.table[getKeyHash(key)];
		if (list == null) return null;
		
		for (Entry<K, V> entry : list)
			if (entry.key.equals(key))
				return entry.value;
		
		return null;
	}

	@Override
	public V remove(K key)
	{
		List<Entry<K, V>> list = this.table[getKeyHash(key)];
		if (list == null) return null;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).key.equals(key))
			{
				this.size--;
				return list.remove(i).value;
			}
		}
		
		return null;
	}

	@Override
	public List<K> getKeys()
	{
		List<K> keys = new SList<K>();
		
		for (List<Entry<K, V>> list : this.table)
			if (list != null)
				for (Entry<K, V> entry : list)
					keys.add(entry.key);
		
		return keys;
	}

	@Override
	public List<V> getValues()
	{
		List<V> values = new SList<V>();
		
		for (List<Entry<K, V>> list : this.table)
			if (list != null)
				for (Entry<K, V> entry : list)
					values.add(entry.value);
		
		return values;
	}
	
	@Override
	public List<Entry<? extends K, ? extends V>> getEntries()
	{
		List<Entry<? extends K, ? extends V>> entries = new SList<Entry<? extends K, ? extends V>>();
		
		for (List<Entry<K, V>> list : this.table)
			entries.addAll(list);
		
		return entries;
	}

	@Override
	public List<K> getKeys(Conditions condition, K rel)
	{
		List<K> keys = new PSList<K>();
	
		if (condition == Conditions.EQUAL)
		{
			if (hasKey(rel))
				keys.add(rel);
		}
		else
		{
			for (List<Entry<K, V>> list : this.table)
				if (list != null)
					for (Entry<K, V> entry : list)
						if (condition.check(entry.key.compareTo(rel)))
							keys.add(entry.key);
		}
		
		return keys;
	}

	@Override
	public List<V> getValues(Conditions condition, V rel)
	{
		List<V> values = new PSList<V>();
		
		for (List<Entry<K, V>> list : this.table)
			if (list != null)
				for (Entry<K, V> entry : list)
					if (condition.check(entry.value.compareTo(rel)))
						values.add(entry.value);
		
		return values;
	}

	@Override
	public List<Entry<? extends K, ? extends V>> getEntries(Conditions condition, K rel)
	{
		List<Entry<? extends K, ? extends V>> entries = new PSList<Entry<? extends K, ? extends V>>();
		
		if (condition == Conditions.EQUAL)
		{
			V value = get(rel);
			
			if (value != null)
				entries.add(new Entry<K, V>(rel, value));
		}
		else
		{
			for (List<Entry<K, V>> list : this.table)
				if (list != null)
					for (Entry<K, V> entry : list)
						if (condition.check(entry.key.compareTo(rel)))
							entries.add(new Entry<K, V>(entry.key, entry.value));
		}
		
		return entries;
	}

}

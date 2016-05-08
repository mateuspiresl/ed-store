package ed.store.database.interfaces;

import ed.store.database.enums.Structures;

public interface Database {

	public Struct<Object> create(Structures struct, String name);
	public <T> Struct<T> create(Structures struct, String name, T[] type);

	public Struct<Object> pull(String name);
	public <T> Struct<T> pull(String name, T[] type);
	
	public Table createTable(String name);
	
	public Table pullTable(String name);

	public void push();

	public void drop(String name);
	public void dropAll();

}
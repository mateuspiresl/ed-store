package ed.store.database;

import java.util.Map;

import ed.store.database.enums.Structures;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Struct;
import ed.store.database.interfaces.Table;

public class StructuresDatabase implements Database {

	public Map<String, Struct> structures;
	public Map<String, Table> tables;
	
	public StructuresDatabase()
	{
		
	}
	
	@Override
	public Struct<Object> create(Structures struct, String name) {
		return create(struct, name, new Object[0]);
	}

	@Override
	public <T> Struct<T> create(Structures struct, String name, T[] type)
	{
		switch (struct)
		{
		//case LIST:	return new DBList<T>();
		//case STACK:	return new DBStack<T>();
		//case QUEUE:	return new DBQueue<T>();
		//case TREE:	return new DBTree<T>();
		//case SET:	return new DBSet<T>();
		
		default:	throw new NullPointerException("$struct must not be null");
		}
	}

	@Override
	public Table createTable(String name) {
		return 
	}

	@Override
	public Struct<Object> pull(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Struct<T> pull(String name, T[] type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table pullTable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropAll() {
		// TODO Auto-generated method stub
		
	}

}

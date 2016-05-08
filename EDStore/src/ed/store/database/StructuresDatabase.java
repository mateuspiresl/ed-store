package ed.store.database;

import java.util.HashMap;
import java.util.Map;

import ed.store.database.enums.Structures;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Struct;
import ed.store.database.interfaces.Table;

public class StructuresDatabase implements Database {

	public String name;
	public Set<String> structuresNames = new HashMap<String, Struct>();
	public Map<String, Modifiable> structures = new HashMap<String, Struct>();
	//public Map<String, Table> tables = new HashMap<String, Struct>();
	
	public StructuresDatabase(String name)
	{
		this.name = name;
		FileHandler.write("db_" + name + "_structures.sdb", this.structuresNames);
	}

	private String makePath(String name) {
		return "db_" + this.name + "_" + structName;
	}

	private File createFile(String name)
	{
		File file = new File(makePath(name));

		if (file.exists())
			throw InvalidNameException("A structure named " + structName + " already exists");

		return file;
	}

	private File getFile(String name)
	{
		File file = new File(makePath(name));

		if ( ! file.exists())
			throw InvalidNameException("A structure named " + structName + " doesn't exists");

		return file;
	}


	private Modifiable getOrPull(String name)
	{
		if (this.structures.containsKey(name))
			return this.structures.get(name);

		Modifiable struct = (Modifiable) FileHandler.read(getFile(name));
		this.structures.put(name, struct);
		return struct;
	}
	
	@Override
	public Struct<Object> create(Structures struct, String name) throws InvalidNameException {
		return create(struct, name, new Object[0]);
	}

	@Override
	public <T> Struct<T> create(Structures struct, String structName, T[] type) throws InvalidNameException;
	{
		File file = createFile(structName);
		Struct<T> struct;

		switch (struct)
		{
		//case LIST:	struct = new SList<T>();	break;
		//case STACK:	struct = new SStack<T>();	break;
		//case QUEUE:	struct = new SQueue<T>();	break;
		//case TREE:	struct = new STree<T>();	break;
		//case SET:		struct = new SSet<T>();	break;
		default:		throw new NullPointerException("$struct must not be null");
		}
		
		FileHandler.write(file, struct);
		this.structuresNames.add(struct);
		this.structures.put(structName, struct);
		return struct;
	}

	@Override
	public Table createTable(String name)
	{
		File file = createFile(structName);
		Table table = null; // TODO: new Table();
		
		FileHandler.write(file, table);
		this.structuresNames.add(table);
		this.structures.put(structName, table);
		return table;
	}

	@Override
	protected Struct<Object> pull(String name) {
		return pull(name, new Object[0]);
	}

	@Override
	public <T> Struct<T> pull(String name, T[] type) {
		return (Struct<T>) getOrPull(name);
	}

	@Override
	public Table pullTable(String name) {
		return (Table) getOrPull(name);
	}

	@Override
	public void push()
	{
		for (String name : this.structuresNames)
		{
			Modifiable struct = this.structures.get(name);

			if (struct.wasModified())
				FileHandler.write(makePath(name), struct);
		}
	}

	@Override
	public void drop(String name)
	{
		new File(makePath(name)).delete();
		this.structures.remove(name);
		this.structuresNames.remove(name);
	}

	@Override
	public void dropAll()
	{
		for (String name : structuresNames)
			new File(makePath(name)).delete();

		this.structures.clear();
		this.structuresNames.clear();
	}

}

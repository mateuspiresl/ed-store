package ed.store.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import ed.store.database.enums.Structures;
import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Map;
import ed.store.database.interfaces.Modifiable;
import ed.store.database.interfaces.Set;
import ed.store.database.interfaces.Struct;
import ed.store.database.structures.SMap;
import ed.store.database.structures.serializables.PSList;
import ed.store.database.structures.serializables.PSMap;
import ed.store.database.structures.serializables.PSQueue;
import ed.store.database.structures.serializables.PSSet;
import ed.store.database.structures.serializables.PSStack;
import ed.store.database.structures.serializables.PSTable;
import ed.store.database.structures.serializables.PSTree;

public class StructuresDatabase implements Database, Serializable {

	public String name;
	public Set<String> structuresNames = new PSSet<String>();
	public transient Map<String, Modifiable> structures = new SMap<String, Modifiable>();
	
	public StructuresDatabase(String name) {
		this.name = name;
	}

	private String makePath(String name) {
		return "db_" + this.name + "_" + name;
	}
	
	@Override
	public Struct create(Structures structType, String structName) throws InvalidNameException, FileNotFoundException, IOException {
		return create(structType, structName, new Object[0]);
	}

	@Override
	public <T> Struct create(Structures structType, String structName, T[] type) throws InvalidNameException, FileNotFoundException, IOException {
		return create(structType, structName, type, new Object[0]);
	}
	
	@Override
	public <T, V> Struct create(Structures structType, String structName, T[] type, V[] type2) throws InvalidNameException, FileNotFoundException, IOException
	{
		File file = FileHandler.createFile(makePath(structName));
		Modifiable struct;

		switch (structType)
		{
		case LIST:	struct = new PSList<T>();	break;
		case STACK:	struct = new PSStack<T>();	break;
		case QUEUE:	struct = new PSQueue<T>();	break;
		case TREE:	struct = new PSTree<T>();	break;
		case SET:	struct = new PSSet<T>();	break;
		case MAP:	struct = new PSMap<T, V>();	break;
		case TABLE:	struct = new PSTable();		break;
		default:	throw new NullPointerException("$struct must not be null");
		}
		
		FileHandler.write(file, struct);
		this.structuresNames.insert(structName);
		this.structures.put(structName, struct);
		return (Struct) struct;
	}

	@Override
	public Struct pull(String name) throws ClassNotFoundException, IOException, InvalidNameException
	{
		if (this.structures.hasKey(name))
			return (Struct) this.structures.get(name);

		Modifiable struct = (Modifiable) FileHandler.read(FileHandler.getFile(makePath(name)));
		this.structures.put(name, struct);
		return (Struct) struct;
	}

	@Override
	public void push() throws FileNotFoundException, IOException
	{
		for (String name : this.structures.getKeys()) {
			Modifiable struct = this.structures.get(name);

			if (struct.wasModified())
			{
				FileHandler.write(makePath(name), struct);
				struct.notifySaving();
			}
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
		for (String name : this.structuresNames.toArray())
			new File(makePath(name)).delete();

		this.structures.clear();
		this.structuresNames.clear();
	}

}

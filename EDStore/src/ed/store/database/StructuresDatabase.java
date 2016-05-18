package ed.store.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import ed.store.database.enums.Structures;
import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.exceptions.NoPermissionException;
import ed.store.database.exceptions.UnknownTypeException;
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
import ed.store.database.structures.serializables.PSTree;

public class StructuresDatabase implements Database, Serializable {

	public String name;
	public Set<String> structuresNames = new PSSet<String>();
	public transient Map<String, Modifiable> structures = new SMap<String, Modifiable>();
	
	public StructuresDatabase(String name) {
		this.name = name;
	}

	private String makePath(String name) {
		return StructuresDBMS.makePath(this.name + "_" + name);
	}
	
	private void create(Modifiable struct, String structName, File file) throws InvalidNameException, NoPermissionException
	{
		FileHandler.write(file, struct);
		this.structuresNames.insert(structName);
		this.structures.put(structName, struct);
	}
	
	public void create(Modifiable struct, String structName) throws InvalidNameException, NoPermissionException
	{
		File file = FileHandler.createFile(makePath(structName));
		create(struct, structName, file);
	}

	@Override
	public <T extends Serializable> Struct create(Structures structType, String structName, T[] type) throws InvalidNameException, NoPermissionException, UnknownTypeException
	{
		Modifiable struct;
		
		switch (structType)
		{
		case LIST:	struct = new PSList<T>();	break;
		case STACK:	struct = new PSStack<T>();	break;
		case QUEUE:	struct = new PSQueue<T>();	break;
		case TREE:	struct = new PSTree<T>();	break;
		case SET:	struct = new PSSet<T>();	break; 
		default:	throw new UnknownTypeException();
		}
		
		create(struct, structName);
		return (Struct) struct;
	}
	
	@Override
	public <T extends Serializable, V extends Serializable> Struct create(Structures structType, String structName, T[] type, V[] type2) throws InvalidNameException, NoPermissionException, UnknownTypeException
	{
		Modifiable struct;
		
		switch (structType)
		{
		case MAP:	struct = new PSMap<T, V>();	break;
		default:	return create(structType, structName, type);
		}

		create(struct, structName);
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
	public synchronized void push() throws NoPermissionException
	{
		for (String name : this.structures.getKeys()) {
			Modifiable struct = this.structures.get(name);

			if (struct.wasModified())
			{
				File file = null;
				try {
					file = FileHandler.getFile(makePath(name));
				} catch (InvalidNameException ine) {
					try {
						file = FileHandler.createFile(name);
					} catch (InvalidNameException ine2) {
						// The first InvalidNameException ensures the inexistence of
						//		a file with same name, so the second will be never thrown 
					}
				}
				
				FileHandler.write(file, struct);
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

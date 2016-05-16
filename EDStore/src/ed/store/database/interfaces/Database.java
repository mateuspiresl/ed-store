package ed.store.database.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import ed.store.database.enums.Structures;
import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.exceptions.NoPermissionException;
import ed.store.database.exceptions.UnknownTypeException;

public interface Database {
	
	public void create(Modifiable struct, String structName) throws InvalidNameException, NoPermissionException;
	public Struct create(Structures struct, String name) throws InvalidNameException, FileNotFoundException, IOException, NoPermissionException, UnknownTypeException;
	public <T extends Serializable> Struct create(Structures struct, String name, T[] type) throws InvalidNameException, FileNotFoundException, IOException, NoPermissionException, UnknownTypeException;
	public <T extends Serializable, V extends Serializable> Struct create(Structures structType, String structName, T[] type, V[] type2) throws InvalidNameException, FileNotFoundException, IOException, NoPermissionException, UnknownTypeException;
	
	public Struct pull(String name) throws ClassNotFoundException, IOException, InvalidNameException;
	public void push() throws NoPermissionException;

	public void drop(String name);
	public void dropAll();

}
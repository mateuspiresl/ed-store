package ed.store.database.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import ed.store.database.enums.Structures;
import ed.store.database.exceptions.InvalidNameException;

public interface Database {

	public Struct create(Structures struct, String name) throws InvalidNameException, FileNotFoundException, IOException;
	public <T> Struct create(Structures struct, String name, T[] type) throws InvalidNameException, FileNotFoundException, IOException;
	public <T, V> Struct create(Structures structType, String structName, T[] type, V[] type2) throws InvalidNameException, FileNotFoundException, IOException;
	
	public Struct pull(String name) throws ClassNotFoundException, IOException, InvalidNameException;
	public void push() throws FileNotFoundException, IOException;

	public void drop(String name);
	public void dropAll();

}
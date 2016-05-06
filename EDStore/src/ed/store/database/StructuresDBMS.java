package ed.store.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import ed.store.database.exceptions.InvalidSystemFileException;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.DatabaseManagementSystem;

public class StructuresDBMS implements DatabaseManagementSystem {

	private static final String FILENAME = "system.sdb";

	private static StructuresDBMS instance;
	private Map<String, Database> databases;
	
	@SuppressWarnings("unchecked")
	private StructuresDBMS()
	{
		File system = new File(FILENAME);
		
		try
		{
			if (system.exists())
			{
				FileInputStream fis = new FileInputStream(system);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				
				if (obj instanceof Map<?, ?>)
					this.databases = (Map<String, Database>) obj;
				else
				{
					fis.close();
					throw new InvalidSystemFileException("system.sdb is invalid");
				}
				
				fis.close();
			}
			else
			{
				FileOutputStream fos = new FileOutputStream(system);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(this.databases);
				
				fos.close();
			}
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public StructuresDBMS instanciate()
	{
		if (instance == null)
			instance = new StructuresDBMS();
		
		return instance;
	}
	
	@Override
	public Database create(String name)
	{
		
	}

	@Override
	public Database load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database drop(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database dropAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

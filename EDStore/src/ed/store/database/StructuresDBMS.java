package ed.store.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NoPermissionException;

import ed.store.database.exceptions.InvalidSystemFileException;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.DatabaseManagementSystem;

public class StructuresDBMS implements DatabaseManagementSystem {

	private static final String FILENAME = "system.sdb";

	private static StructuresDBMS instance;
	private Map<String, Database> databases;
	
	@SuppressWarnings("unchecked")
	private StructuresDBMS() throws NoPermissionException
	{
		try {
			this.databases = (Map<String, Database>) FileHandler.read(FILENAME);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			
			this.databases = new HashMap<String, Database>();
			
			try {
				FileHandler.write("system.sdb", this.databases);
			} catch (IOException e2) {
				e2.printStackTrace();
				
				throw new NoPermissionException();
			}
		}
	}
	
	public StructuresDBMS instanciate() throws NoPermissionException
	{
		if (instance == null)
			instance = new StructuresDBMS();
		
		return instance;
	}
	
	@Override
	public Database create(String name)
	{
		Database db = new StructuresDatabase(name);
		this.databases.add(db);
		return db;
	}

	@Override
	public void load(String name) {
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

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}

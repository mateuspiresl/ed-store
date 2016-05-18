package ed.store.database;

import java.io.File;
import java.io.IOException;

import ed.store.database.exceptions.CorruptedFileException;
import ed.store.database.exceptions.DatabaseOverwriteException;
import ed.store.database.exceptions.InvalidFileException;
import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.exceptions.NoPermissionException;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Map;
import ed.store.database.structures.SMap;
import ed.store.database.structures.serializables.PSSet;

public class StructuresDBMS {

	private static final String FILENAME = "sdb/system.sdb";

	private static StructuresDBMS instance;
	private PSSet<String> databasesNames;
	private Map<String, Database> databases;
	
	private StructuresDBMS(PSSet<String> databasesNames)
	{
		this.databasesNames = databasesNames;
		this.databases = new SMap<String, Database>();
	}
	
	private StructuresDBMS() throws NoPermissionException
	{
		this(new PSSet<String>());
		FileHandler.write(FILENAME, this.databasesNames);
	}
	
	public static String makePath(String name) {
		return "sdb/db_" + name + ".sdb";
	}
	
	/* Cria um DBMS.
	 * Se existir um, apaga o existente e cria um novo. */
	public static StructuresDBMS create() throws NoPermissionException, DatabaseOverwriteException
	{
		File dir = new File("sdb/");
		if ( ! dir.exists()) dir.mkdirs();
		
		try {
			FileHandler.getFile(FILENAME);
		} catch (InvalidNameException ine) {
			throw new DatabaseOverwriteException(ine);
		}
		
		StructuresDBMS.instance = new StructuresDBMS();
		return StructuresDBMS.instance;
	}
	
	/* Abre um DBMS existente. */
	@SuppressWarnings("unchecked")
	public static StructuresDBMS open() throws InvalidFileException
	{
		try
		{
			StructuresDBMS.instance = new StructuresDBMS((PSSet<String>) FileHandler.read(FILENAME));
			return StructuresDBMS.instance;
		}
		catch (ClassNotFoundException | IOException | InvalidNameException e) {
			throw new InvalidFileException(e);
		}
	}
	
	/* Retorna a instancia do DBMS aberto. */
	public static StructuresDBMS get()
	{
		if (StructuresDBMS.has())
			return StructuresDBMS.instance;
		else
			throw new NullPointerException("Has no instance of StructuresDMBS.");
	}
	
	/* Checks if it has a instance of StructuresDBMS. */
	public static boolean has() {
		return StructuresDBMS.instance != null;
	}
	
	/* Delete the StructuresDMBS' file and instance. */
	public static void drop()
	{
		if (StructuresDBMS.has())
		{
			File dir = new File("sdb/");
			
			// Delete *.sdb
			for (File file : dir.listFiles())
				if (file.getName().endsWith(".sdb"))
					file.delete();
		
			StructuresDBMS.instance = null;
		}
		else throw new NullPointerException("It has no instance of StructuresDMBS.");
	}
	
	public Database createDatabase(String name) throws NoPermissionException, InvalidNameException
	{
		// It is not possible to create two databases with the same name
		if (this.databasesNames.has(name))
			throw new InvalidNameException("A database named " + name + " already exists.");
		
		String path = makePath(name);
		Database db = new StructuresDatabase(name);
		try {
			try {
				FileHandler.write(FileHandler.createFile(path), db);
			} catch (InvalidNameException e) {
				// If there is a file with the same name, it should be deleted
				// As there is no database with the name given, this file does
				//		not belong to any database
				File existent = FileHandler.getFile(path);
				existent.delete();
				FileHandler.write(FileHandler.createFile(path), db);
			}
		} catch (InvalidNameException e) {
			// If wasn't possible to create the file or delete an existent
			throw new NoPermissionException(e);
		}

		this.databases.put(name, db);
		return db;
	}

	public Database loadDatabase(String name) throws InvalidNameException
	{
		if ( ! this.databasesNames.has(name))
			throw new InvalidNameException("It has no database named " + name);
		
		Database db = this.databases.get(name);
		if (db != null) return db;
		
		try
		{
			File dbFile = FileHandler.getFile(name);
			db = (Database) FileHandler.read(dbFile);
			this.databases.put(name, db);
			return db;
		}
		catch (InvalidNameException | ClassNotFoundException | IOException e) {
			throw new CorruptedFileException(e);
		}
	}

	public void dropDatabase(String name) throws InvalidNameException
	{
		boolean exists =	this.databasesNames.remove(name) ||
							this.databases.remove(name) != null;
		
		try {
			FileHandler.getFile(makePath(name)).delete();
		} catch (InvalidNameException ine) { }
		
		if ( ! exists) throw new InvalidNameException("It has no database named " + name);
	}

	public void dropAll()
	{
		String[] names = this.databasesNames.toArray();
		
		for (String name : names) {
			try {
				dropDatabase(name);
			} catch (InvalidNameException ine) {
				ine.printStackTrace();
			}
		}
	}
	
	public void closeDatabase(String name) throws InvalidNameException, NoPermissionException
	{
		if ( ! this.databasesNames.has(name))
			throw new InvalidNameException("It has no database named " + name);
		
		Database db = this.databases.get(name);
		if (db != null)
		{
			db.push();
			this.databases.remove(name);
		}
	}
	
	public void closeAll() throws NoPermissionException
	{
		for (String name : this.databases.getKeys())
		{			
			try {
				closeDatabase(name);
			} catch (InvalidNameException ine) {
				try {
					dropDatabase(name);
				} catch (InvalidNameException ine2) { }
			}
		}
	}
	
}

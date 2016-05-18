package ed.store.database.tests;

import ed.store.database.StructuresDBMS;
import ed.store.database.enums.Structures;
import ed.store.database.exceptions.DatabaseOverwriteException;
import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.exceptions.NoPermissionException;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Map;

public class DatabaseTest {

	public static void main(String[] args) throws NoPermissionException, InvalidNameException
	{
		StructuresDBMS dbms;
		try {
			dbms = StructuresDBMS.create();
		} catch (DatabaseOverwriteException doe) {
			dbms = StructuresDBMS.open();
		}
		
		Database db = dbms.createDatabase("database");
		
		@SuppressWarnings("unchecked")
		Map<Integer, String> ms = (Map<Integer, String>) db.create(Structures.MAP, "string_map", new Integer[0], new String[0]);
		
		ms.put(1, "Mateus Pires");
		
		System.out.println(ms.get(1));
	}
	
}

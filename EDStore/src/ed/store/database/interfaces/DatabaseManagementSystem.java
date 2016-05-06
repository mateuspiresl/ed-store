package ed.store.database.interfaces;

public interface DatabaseManagementSystem {

	public Database create(String name);
	public Database load(String name);
	public Database drop(String name);
	public Database dropAll();
	
}

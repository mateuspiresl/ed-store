package ed.store.database.interfaces;

public interface DatabaseManagementSystem {

	public Database create(String name);
	public void load(String name);
	public void drop(String name);
	public void dropAll();
	public void delete();
	
}

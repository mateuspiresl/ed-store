public interface Database {

	public Struct<Object> create(Structures struct, String name);
	public <T> Struct<T> create(Structures struct, String name, T[] type);

	public Struct<Object> pull(String name);
	public <T> Struct<T> pull(String name, T[] type);

	public void push();

	public void clear(String name);
	public void drop(String name);
	public void dropAll();

}
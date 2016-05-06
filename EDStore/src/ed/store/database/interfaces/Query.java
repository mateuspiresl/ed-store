package ed.store.database;

public interface Query {

	public <T> void add(String colmun, Conditions condition, T data);
	public <T> void add(String column, Condition<T> condition);
	public <T> void add(String column, Relation<T> relation, T with);

	public setColumn(String name, boolean request);
	public setColumns(String[] names, boolean request);
	public setAllColumns(boolean request);

	public setOffset(int offset);
	public setLimit(int limit);

}
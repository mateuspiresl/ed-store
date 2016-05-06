package ed.store.database.interfaces;

import ed.store.database.Conditions;

public interface Query {

	public <T> void add(String colmun, Conditions condition, T data);
	public <T> void add(String column, Condition<T> condition);
	public <T> void add(String column, Relation<T> relation, T with);

	public void setColumn(String name, boolean request);
	public void setColumns(String[] names, boolean request);
	public void setAllColumns(boolean request);

	public void setOffset(int offset);
	public void setLimit(int limit);

}
package ed.store.database.structures;

import java.io.Serializable;

import ed.store.database.KeyValuePair;
import ed.store.database.interfaces.ColumnValidator;
import ed.store.database.interfaces.Query;
import ed.store.database.interfaces.Table;

public class STable implements Table, Serializable {

	public STable(){
		// TODO
	}
	
	public STable(STable table){
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Comparable<Object>> void addColumn(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue, T[] type) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue, T[] type,
			ColumnValidator<T> validator) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(KeyValuePair[] data) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[][] select(Query query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(Query query) {
		// TODO Auto-generated method stub
		return 0;
	}

}

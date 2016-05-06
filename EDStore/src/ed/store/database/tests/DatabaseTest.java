package ed.store.database.tests;

import ed.store.database.KeyValuePair;
import ed.store.database.enums.Conditions;
import ed.store.database.enums.Structures;
import ed.store.database.interfaces.ColumnValidator;
import ed.store.database.interfaces.Conditional;
import ed.store.database.interfaces.Database;
import ed.store.database.interfaces.Query;
import ed.store.database.interfaces.Relational;
import ed.store.database.interfaces.Table;

public class DatabaseTest {

	public static void main(String[] args)
	{
		Database db = new StructuresDatabase();
		
		Table t = db.createTable("my_table");
		
		t.addColumn("name", null, new String[0], new ColumnValidator<String>() {
				@Override
				public boolean validate(String data) {
					return data.length() >= 3 && data.matches("[a-zA-Z ]*");
				}
			});
		t.addColumn("age", new DataStruct(1, 2), new DataStruct[0], new ColumnValidator<DataStruct>() {
			@Override
			public boolean validate(DataStruct data) {
				return data.a != data.b;
			}
		});
		t.addColumn("packet", null);
		
		t.insert(new KeyValuePair[] {
				new KeyValuePair("name", "Mateus Pires"),
				new KeyValuePair("age", "21"),
				new KeyValuePair("packet", new DataStruct(2, 3))
			});
		t.insert(new KeyValuePair[] {
				new KeyValuePair("name", "abc123"),
				new KeyValuePair("age", "5"),
				new KeyValuePair("packet", new DataStruct(2, 2))
			});
		
		Query q = new BasicQuery();
		
		q.add("name", Conditions.GREATER, "A");
		q.add("age", new Conditional<Integer>() {
				@Override
				public boolean check(Integer data) {
					return data >= 18 && data <= 50;
				}
			});
		q.add("packet", new Relational<DataStruct>() {
				@Override
				public boolean check(DataStruct data, DataStruct rel) {
					return data.a < rel.a && data.b > rel.b;
				}
			}, null);
		
		Object[][] data = t.select(q);
		
		for (Object[] row : data)
			for (Object col : row)
				System.out.println(col);
	}
	
	
	private static class DataStruct implements Comparable<DataStruct> {
		
		public int a, b;
		
		public DataStruct(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(DataStruct comp) {
			return this.a + this.b - comp.a + comp.b;
		}
		
	}
	
}

package ed.store.database.interfaces;

import ed.store.database.KeyValuePair;

public interface Table extends Struct {

	public <T extends Comparable<Object>> void addColumn(String name);
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue);
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue, T[] type);
	public <T extends Comparable<T>> void addColumn(String name, T defaultValue, T[] type, ColumnValidator<T> validator);

	/* Retorna um array com todas os nomes das colunas. */ 
	public String[] getColumns();
	
	/* Insere uma linha na tabela.
	 * @param data - dados no formato: [ nome_da_coluna_1, valor_1,
	 *		nome_da_coluna_2, valor_2, ... ] */
	public void insert(KeyValuePair[] data);

	/* Requisita linhas da tabela que obedecem a query. */
	public Object[][] select(Query query);

	/* Remove linhas da tabela que obedecem a query. */
	public int remove(Query query);

}
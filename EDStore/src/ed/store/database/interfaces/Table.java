package ed.store.database.interfaces;

public interface Table {

	public boolean wasModified();

	public <T> void addColumn(String name, T defaultValue);
	public <T> void addColumn(String name, T defaultValue, T[] type);
	public <T> void addColumn(String name, T defaultValue, T[] type, ColumnValidator<T> validator);

	/* Insere uma linha na tabela.
	 * @param data - dados no formato: [ nome_da_coluna_1, valor_1,
	 *		nome_da_coluna_2, valor_2, ... ] */
	public void insert(Object[] data);

	/* Requisita linhas da tabela que obedecem a query. */
	public Object[][] select(Query query);

	/* Remove linhas da tabela que obedecem a query. */
	public int remove(Query query);

}
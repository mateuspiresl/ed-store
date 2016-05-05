package ed.store.database.interfaces;

public interface List<T> extends Struct<T> {

	public int add(T data);
	public int insert(T data, int index);

	public void set(int index, T data);
	/* Modificar a primeira ocorrência de curr para data
	 * @return - índice do elemento modificado */
	public int set(T curr, T data);
	/* Modificar todos as ocorrências de curr para data
	 * @return - índices dos elementos modificados */
	public int[] setAll(T curr, T data);

	public T remove(int index);
	/* Remove o primeiro elemento de valor data 
	 * @return - índice do elemento removido */
	public int remove(T data);
	/* Remove todos os elementos de valor data 
	 * @return - array com os elementos removidos */
	public T[] removeAll(T data);

	public T get(int index);

	/* �?ndice do primeiro elemento de valor data dentro de
	 *		um intervalo.
	 * @param data - valor do elemento.
	 * @param offset - primeira posição verificada.
	 * @param limit - número de elementos para verificar.
	 * @return - índice. */
	public int indexOf(T data, int offset, int limit);
	public int[] indexOfAll(T data);
	/* �?ndices de todos os elementos de valor data dentro de
	 *		um intervalo.
	 * @param data - valor do elemento.
	 * @param offset - primeira posição verificada.
	 * @param limit - número de elementos para verificar.
	 * @return - array de índices. */
	public int[] indexOfAll(T data, int offset, int limit);

	/* Array de todos os elementos da lista.
	 * @return - array com todos os elementos. */
	// public T[] toArray();
	
	/* Array de todos os elementos da lista dentro de um
	 *		intervalo.
	 * @param offset - primeira posição.
	 * @param limit - número de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int offset, int limit);

}
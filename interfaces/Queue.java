public interface Queue<T> extends Struct<T> {

	public T first();
	public void enqueue(T data);
	public T dequeue();

	/* Índice do primeiro elemento de valor data.
	 * @param data - valor do elemento.
	 * @return - altura. */
	// public int indexOf(T data);

	/* Índice do primeiro elemento de valor data dentro da
	 * 		quantidade limite.
	 * @param limit - quantidade limite.
	 * @return - Índice. */
	public int indexOf(T data, int limit);

	/* Array de todos os elementos da fila.
	 * @return - array de elementos. */
	// public T[] toArray();
	
	/* Array de n elementos da fila.
	 * @param limit - número de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int limit);

}
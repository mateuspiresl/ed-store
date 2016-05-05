package ed.store.database.interfaces;

public interface Queue<T> extends Struct<T> {

	public T first();
	public void enqueue(T data);
	public T dequeue();

	/* �ndice do primeiro elemento de valor data.
	 * @param data - valor do elemento.
	 * @return - altura. */
	// public int indexOf(T data);

	/* �ndice do primeiro elemento de valor data dentro da
	 * 		quantidade limite.
	 * @param limit - quantidade limite.
	 * @return - �ndice. */
	public int indexOf(T data, int limit);

	/* Array de todos os elementos da fila.
	 * @return - array de elementos. */
	// public T[] toArray();
	
	/* Array de n elementos da fila.
	 * @param limit - n�mero de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int limit);

}
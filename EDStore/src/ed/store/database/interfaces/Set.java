package ed.store.database.interfaces;

public interface Set<T> extends Struct<T> {

	public int has(T data);
	public int insert(T data);
	public int remove(T data);

	/* Array de todos os elementos da lista.
	 * @return - array com todos os elementos. */
	public T[] toArray();
	
	/* Array de todos os elementos da lista dentro de um
	 *		intervalo.
	 * @param limit - número de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int limit);

}
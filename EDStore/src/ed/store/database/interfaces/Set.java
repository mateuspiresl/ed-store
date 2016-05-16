package ed.store.database.interfaces;

public interface Set<T> extends Struct {

	public boolean has(T data);
	public boolean insert(T data);
	public boolean remove(T data);

	public int indexOf(T data);

	/* Array de todos os elementos da lista.
	 * @return - array com todos os elementos. */
	public T[] toArray();
	
	/* Array de todos os elementos da lista dentro de um
	 *		intervalo.
	 * @param limit - número de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int limit);

}
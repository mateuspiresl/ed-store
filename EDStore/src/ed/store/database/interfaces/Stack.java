package ed.store.database.interfaces;

public interface Stack<T> extends Struct<T> {

	public T top();
	public void push(T data);
	public T pop();

	/* Altura do primeiro elemento de valor data.
	 * @param data - valor do elemento.
	 * @return - altura. */
	public int indexOf(T data);

	/* Altura do primeiro elemento de valor data acima de
	 *		uma altura m�nima.
	 * @param limit - altura m�nima.
	 * @return - altura. */
	public int indexOf(T data, int limit);

	/* Array de todos os elementos da pilha.
	 * @return - array de elementos. */
	public T[] toArray();

	/* Array de n elementos da pilha.
	 * @param limit - n�mero de elementos.
	 * @return - array de elementos. */
	public T[] toArray(int limit);

}
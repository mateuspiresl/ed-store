public interface Struct<T> {
	
	/* Verifica se a estrutura foi modificada. */
	public void wasModified();

	public int size();
	public boolean isEmpty();
	public int indexOf(T data);
	public void clear();
	public T[] toArray();

}
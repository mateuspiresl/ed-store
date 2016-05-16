package ed.store.database.structures;

import java.io.Serializable;

import ed.store.database.interfaces.List;
import ed.store.database.structures.serializables.PSList;

public class SList<T> implements List<T>, Serializable {

	public SList() {
		// TODO		
	}
	
	public SList(SList list) {
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int add(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAll(T[] data) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void addAll(List<? extends T> data) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insert(T data, int index) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void insertAll(T[] data, int index) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void insertAll(List<? extends T> data, int index)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(int index, T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int set(T curr, T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] setAll(T curr, T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] removeAll(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(T data, int offset, int limit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] indexOfAll(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] indexOfAll(T data, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}

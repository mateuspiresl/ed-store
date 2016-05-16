package ed.store.database.structures;

import java.io.Serializable;

import ed.store.database.interfaces.Stack;

public class SStack<T> implements Stack<T>, Serializable {

	public SStack() {
		// TODO
	}
	
	public SStack(SStack<T> stack) {
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
	public T top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(T data, int limit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}

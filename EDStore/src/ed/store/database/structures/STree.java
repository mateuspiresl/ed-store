package ed.store.database.structures;

import ed.store.database.interfaces.List;
import ed.store.database.interfaces.Struct;


public class STree<T> implements Struct {

	private static final long serialVersionUID = 1L;
	
	private TreeNode root;
	private int size;
	
	public TreeNode getRoot() {
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		root = null;
	}
	
	
	public class TreeNode {
		T data;
		List<TreeNode> childs;
		TreeNode parent;
		
		public TreeNode getParent() {
			return this.parent;
		}
		
		public int getChildCount() {
			return childs.size();
		}
		
		public TreeNode childAt(int index) {
			return childs.get(index);
		}
		
		public List<TreeNode> getChilds() {
			return this.childs;
		}
		
		public T getData() {
			return this.data;
		}
		
		public int getIndex() {
			return parent.indexOf(this);
		}
		
		public int indexOf(TreeNode node) {
			int childCount = parent.childs.size();
			for (int i = 0; i < childCount; i++) {
				if (parent.childs.get(i) == node) {
					return i;
				}
			}
			
			return -1;
		}
		
	}
	
}

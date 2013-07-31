package adt.util;

public class BST<T extends Comparable<T>> implements BSTInterface<T> {
	BSTNode<T> root;
	int length;

	public BST() {
		root = null;
		length=0;
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		root = recAdd(data, this.root);
		length+=1;
	}

	private BSTNode<T> recAdd(T data, BSTNode<T> tree) {
		// TODO Auto-generated method stub
		if (tree == null) {
			tree = new BSTNode<T>(data);
		} else if (data.compareTo(tree.getData()) <= 0) {
			tree.setLeft(recAdd(data, tree.getLeft()));
		} else if (data.compareTo(tree.getData()) > 0) {
			tree.setRight(recAdd(data, tree.getRight()));
		}
		return tree;
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub
		try {
			recRemove(data, this.root);
		} catch (EmptyBSTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		length-=1;
	}

	
	private void recRemove(T data, BSTNode<T> root2) throws EmptyBSTException, DataNotFoundException {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			if (contains(data)) {
				
			} else {
				throw new DataNotFoundException("No data");
			}
		} else {
			throw new EmptyBSTException("Empty BST!");
		}
	}

	@Override
	public boolean contains(T data) {
		return recContains(data, this.root);
	}

	private boolean recContains(T data, BSTNode<T> root) {
		// when root is null 
		if (root == null) {
			return false;
		}
		
		if(data.compareTo(root.getData())==0) {
			return true;
		} else if (data.compareTo(root.getData())<0) {
			return recContains(data,root.getLeft());
		} else  {
			return recContains(data,root.getRight());
		} 
		//return false;
		
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return(root == null);	
	}

	@Override
	public String inOrder() {
		return inOrder(this.root);
	}

	public String inOrder(BSTNode<T> branch) {
		String toReturn = "";
		// Left
		if (branch.getLeft() != null) {
			toReturn += inOrder(branch.getLeft());
		}
		// Root
		toReturn += branch.getData().toString();

		// Right
		if (branch.getRight() != null) {
			toReturn += inOrder(branch.getRight());
		}

		return toReturn;
	}

	@Override
	public String preOrder() {
		return preOrder(this.root);
	}

	public String preOrder(BSTNode<T> branch) {

		String toReturn = "";
		// Root
		toReturn += branch.getData().toString();

		// Left
		if (branch.getLeft() != null) {
			toReturn += preOrder(branch.getLeft());
		}

		// Right
		if (branch.getRight() != null) {
			toReturn += preOrder(branch.getRight());
		}

		return toReturn;

	}

	@Override
	public String postOrder() {
		return postOrder(this.root);
	}

	public String postOrder(BSTNode<T> branch) {

		String toReturn = "";
		// Left
		if (branch.getLeft() != null) {
			toReturn += postOrder(branch.getLeft());
		}

		// Right
		if (branch.getRight() != null) {
			toReturn += postOrder(branch.getRight());
		}

		// Root
		toReturn += branch.getData().toString();

		return toReturn;

	}

}

package adt.util;

public class BST<T extends Comparable<T>> implements BSTInterface<T> {
	BSTNode<T> root;
	int length;
	boolean found = false;

	public BST() {
		root = null;
		length = 0;
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		root = recAdd(data, this.root);
		length += 1;
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

	public boolean remove(T data) throws EmptyBSTException {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			try {
				root = recRemove(data, this.root);
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block

			}
		} else {
			throw new EmptyBSTException("BST is empty!");
		}

		length -= 1;
		return found;
	}

	private BSTNode<T> recRemove(T data, BSTNode<T> tree)
			throws EmptyBSTException, DataNotFoundException {
		// TODO Auto-generated method stub
		if (tree == null) {
			found = false;
		} else if (data.compareTo(tree.getData()) < 0) {
			tree.setLeft(recRemove(data, tree.getLeft()));
		} else if (data.compareTo(tree.getData()) > 0) {
			tree.setRight(recRemove(data, tree.getRight()));
		} else {
			found = true;
			tree = removeNode(tree);

		}
		return tree;

	}

	private BSTNode<T> removeNode(BSTNode<T> tree) throws EmptyBSTException,
			DataNotFoundException {
		if (tree.getLeft() == null) {
			return tree.getRight();
		} else if (tree.getRight() == null) {
			return tree.getLeft();
		} else {
			BSTNode<T> temp = findHighestLeft(tree.getLeft());
			tree.setData(temp.getData());
			tree.setLeft(recRemove(temp.getData(), tree.getLeft()));
		}
		return tree;
	}

	private BSTNode<T> findHighestLeft(BSTNode<T> tree) {
		// TODO Auto-generated method stub
		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree;
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

		if (data.compareTo(root.getData()) == 0) {
			return true;
		} else if (data.compareTo(root.getData()) < 0) {
			return recContains(data, root.getLeft());
		} else {
			return recContains(data, root.getRight());
		}
		// return false;

	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/*
	 * @Override public String inOrder() { return inOrder(this.root); }
	 * 
	 * public String inOrder(BSTNode<T> branch) { String toReturn = ""; // Left
	 * if (branch.getLeft() != null) { toReturn += inOrder(branch.getLeft()); }
	 * // Root toReturn += branch.getData().toString();
	 * 
	 * // Right if (branch.getRight() != null) { toReturn +=
	 * inOrder(branch.getRight()); }
	 * 
	 * return toReturn; }
	 */

	@Override
	public String inOrder() {
		// TODO Auto-generated method stub
		bstList = "";
		return inOrder(this.root);
	}

	String bstList = "";

	public String inOrder(BSTNode<T> tree) {

		// Left
		if (tree != null) {
			inOrder(tree.getLeft());
			// Root
			bstList += tree.getData();
			// Right
			inOrder(tree.getRight());
		}
		return bstList;
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

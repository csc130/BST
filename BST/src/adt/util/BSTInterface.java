package adt.util;

public interface BSTInterface <T extends Comparable> {
	public void add(T data);
	public void remove(T data);
	public boolean contains(T data);
	public int size();
	public boolean isEmpty();
	public String inOrder();
	public String preOrder();
	public String postOrder();
}

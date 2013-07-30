package adt.util;

public class Driver {

	public static void main(String[] args) {
		BST<String> test = new BST<String>();
		test.add("d");
		test.add("f");
		test.add("b");
		test.add("c");
		test.add("a");
		test.add("e");
		test.add("g");
/*		test.add("a");
		test.add("a");
		test.add("a");
		test.add("a");
		test.add("a");
		test.add("f");*/
		
		System.out.println(test.inOrder());
		System.out.println(test.preOrder());
		System.out.println(test.postOrder());
		System.out.println(test.contains("a"));
		System.out.println(test.contains("b"));		
		System.out.println(test.contains("c"));
		System.out.println(test.contains("d"));
		System.out.println(test.contains("e"));		
		System.out.println(test.contains("f"));
		System.out.println(test.contains("g"));
		System.out.println(test.contains("h"));		
		System.out.println(test.contains("i"));
	}

}

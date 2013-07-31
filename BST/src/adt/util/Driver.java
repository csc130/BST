package adt.util;

public class Driver {

	public static void main(String[] args) {
		BST<String> test = new BST<String>();
		try {
			System.out.println(test.remove("S"));
		} catch (EmptyBSTException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		test.add("U");
		test.add("W");
		test.add("V");
		test.add("X");
		test.add("O");
		test.add("Q");
		test.add("P");
		test.add("R");
		test.add("J");
		test.add("L");
		test.add("K");
		test.add("M");
		test.add("N");
		test.add("F");
		test.add("H");
		test.add("I");
		test.add("G");

		/*
		 * test.add("d"); test.add("f"); test.add("b"); test.add("c");
		 * test.add("a"); test.add("e"); test.add("g");
		 */
		/*
		 * test.add("a"); test.add("a"); test.add("a"); test.add("a");
		 * test.add("a"); test.add("f");
		 */

		System.out.println(test.inOrder());
		try {
			System.out.println(test.remove("F"));
		} catch (EmptyBSTException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(test.inOrder());

		/*
		 * System.out.println(test.preOrder());
		 * System.out.println(test.postOrder());
		 */
		/*
		 * System.out.println(test.contains("a"));
		 * System.out.println(test.contains("b"));
		 * System.out.println(test.contains("c"));
		 * System.out.println(test.contains("d"));
		 * System.out.println(test.contains("e"));
		 * 
		 * System.out.println(test.contains("f"));
		 * System.out.println(test.contains("g"));
		 */
		// System.out.println(test.contains("h"));
		// System.out.println(test.contains("i"));
	}

}

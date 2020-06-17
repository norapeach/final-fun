import java.util.Stack;

/**
 * StackChecker.java
 */

/***************************************************************************
 * BJP5 Exercise 14.5: Method equals 
 * 
 * The equals method accepts two Stacks of integers as parameters and returns
 * a boolean value - true if both the Stack size and sequence of values is
 * identical. False otherwise. Both stacks must be returned to their original 
 * state before the return statement. One Stack as auxiliary storage.
 **************************************************************************/
/**
 * @author Nora P.
 * @version 6/16/20 This program tests the an implementation of an equals method
 *          for two Stacks using a third Stack as auxiliary storage.
 */
public class StackChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data1 = { 1, 2, 3, 4, 5, 7, 9, 11 };
		int[] data2 = { 13, 4, 17, 8, 1, 91, 81, 71 };

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>(); // will have equal values to s1

		for (int n : data1)
			s1.add(n);
		for (int n : data2)
			s2.add(n);
		for (int n : data1)
			s3.add(n);

		System.out.println("Stack 1: " + s1);
		System.out.println("Stack 2: " + s2);
		System.out.println("Stack 3: " + s3);
		System.out.println("Stack 1 & 2 equal? >>> " + equals(s1, s2));
		System.out.println("Stack 1 & 3 equal? >>> " + equals(s1, s3));

	}

	/**
	 * Returns true if the given stacks have an equal number and sequence of values
	 */
	public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
		if (s1.size() != s2.size()) { // check size for equality
			return false; // if size isn't equal, immediately return false
		} else {
			Stack<Integer> s3 = new Stack<>(); // permitted 3rd Stack for storage
			boolean same = true;
			while (same && !s1.isEmpty()) { // loop as long as values are equal and s1 has values
				int num1 = s1.pop();
				int num2 = s2.pop();

				if (num1 != num2) {
					same = false;
				} // only changed if mismatch integers found within loop
				s3.push(num1);
				s3.push(num2);
			} // end while

			// reconstruct original stacks then return boolean
			while (!s3.isEmpty()) {
				s2.push(s3.pop()); // remove s2 value from s3 top 1st
				s1.push(s3.pop());
			} // end while
			return same;
		} // end if/else

	} // end method
}

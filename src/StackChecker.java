import java.util.Stack;

/**
 * StackChecker.java
 */

/**
 * @author Nora P.
 * @version 6/16/20
 */
public class StackChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data1 = {1, 2, 3, 4, 5, 7, 9, 11};
		int[] data2 = {13, 4, 17, 8, 1, 91, 81, 71};
		
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
	 * Write a method equals that takes as parameters two stacks of integers and returns true 
	 * if the two stacks are equal and that returns false otherwise. 
	 * To be considered equal, the two stacks would have to store the same sequence 
	 * of integer values in the same order. 
	 * Your method is to examine the two stacks but must return them to their original state before terminating. 
	 * You may use one stack as auxiliary storage.
	 */
	 public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
		 if (s1.size() != s2.size()) { // 1. check size for equality
			 return false; // if size isn't equal, immediately return false
		 } else {
			 Stack<Integer> s3 = new Stack<>(); // permitted 3rd Stack for storage
			 boolean same = true;
			 while (same && !s1.isEmpty()) { // loop as long as values are equal and s1 has values
				 int num1 = s1.pop();
				 int num2 = s2.pop();
				 
				 if (num1 != num2) {
					 same = false;
				 } // only changed if inequal integers are reached within loop
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

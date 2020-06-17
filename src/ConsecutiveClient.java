/**
 * ConsecutiveClient.java
 */

/***************************************************************************
 * ITC155 - Final - Problem 2
 * BJP5 Exercise 16.6: Method hasTwoConsecutive 
 * FIRST METHOD defined after constructor in LinkedIntList.java
 * JUnit test: TODO
 * 
 * REQUIREMENTS
 * - This method has been added to the LinkedIntList class defined in Ch6
 * http://www.buildingjavaprograms.com/code-files/5ed/ch16/LinkedInt.java
 **************************************************************************/
/**
 * This program tests the hasTwoConsecutive method on a list to determine if
 * the list contains two consecutive values in sequence. This version returns
 * ALL pairs of consecutive integers instead of returning the first match.
 * 
 * @author Nora P.
 * @version 06/16/20
 */
public class ConsecutiveClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedIntList list1 = new LinkedIntList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		System.out.println("");
		System.out.println("Original list sequence" + list1);
		System.out.println("Method hasTwoConsecutive Test: >>> " + list1.hasTwoConsecutive());
		System.out.println();

		list1.add(12);
		list1.add(2);
		list1.set(1, 3);

		System.out.println("The List has been modified >>> " + list1);
		System.out.println("Method hasTwoConsecutive Test: >>> " + list1.hasTwoConsecutive());
	}

}

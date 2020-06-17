
/**
 * LinkedIntList.java
 * @version 6/16/20
 */

import java.util.NoSuchElementException;

/**
 * Represents a LinkedIntList data structure to to store a list of integers.
 * 
 * @see http://www.buildingjavaprograms.com/code-files/5ed/ch16/LinkedIntList2.java
 */
public class LinkedIntList implements IntList {
	private ListNode front; // first value in the list

	// post: constructs an empty list
	public LinkedIntList() {
		front = null;
	}

	/**
	 * @return true if the list of integers has two adjacent numbers that are
	 *         consecutive integers e.g. (7,8) otherwise false if no pair is found)
	 */
	public boolean hasTwoConsecutive() {
		boolean twoConsec = false;
		if (front == null) {
			System.out.println("List is empty.");
			return twoConsec;
		} else if (front.next == null) {
			System.out.println("List only contains one Node");
			return twoConsec;
		} else { // List.size() > 2
			ListNode current = front;
			while (current.next != null) {
				int consec = current.data + 1;
				int nextData = current.next.data;
				if (nextData == consec) { // pre: nextData is the next consecutive integer in sequence
					twoConsec = true;
					System.out.println("Consecutive pair found: [" + current.data + ", " + current.next.data + "]");
					// Commented out to show consecutive pairs
					// return twoConsec;
					current = current.next;
				} else {
					// not a consecutive pair, get the next Node to test
					current = current.next;
				}
			} // end while
			return twoConsec;
		} // end if/else
	} // end method

	/**
	 * ASSIGNMENT 8 METHOD
	 * 
	 * @author Nora P.
	 * @version 6/13/20
	 * @return true if the List is in sorted (nondecreasing) sequence
	 */
	public boolean isSorted() {
		boolean sorted = true;
		if (front == null) {
			return sorted;
		} else {
			ListNode current = front;
			while (current.next != null) {
				if (current.data <= current.next.data) {
					current = current.next;
				} else {
					return sorted = false;
				} // end inner if/else
			} // end while
			return sorted;
		} // end if/else

	} // end isSorted

	/**
	 * BJP5 Exercise 16.2: min
	 * 
	 * @author Nora P.
	 * @return The minimum value in a list of integers
	 * @throws NoSuchElementException if the list is empty
	 */
	public int min() throws NoSuchElementException {

		if (front == null) {
			throw new NoSuchElementException("Empty list passed");
		} else {
			ListNode current = front;
			int min = front.data; // stores the 1st value

			while (current.next != null) {
				if (current.next.data < min) {
					min = current.next.data; // replace with new min value
					current = current.next; // set current reference to next node in list
				} else {
					current = current.next; // min is smaller
				}
			} // end while
			return min;
		} // end outer if/else
	}

	// post: returns the current number of elements in the list
	public int count() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// pre : 0 <= index < ()
	// post: returns the integer at the given index in the list
	public int get(int index) {
		return nodeAt(index).data;
	}

	/**
	 * BJP5 Exercise 16.1: set method pre: 0 <= index < () post: sets the list's
	 * element at given index to have the given value
	 * 
	 * @param index The location of the node data value to be set
	 * @param value The value to be set at the given index
	 * @author Nora P.
	 */
	public void set(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front.next);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next.next);
		}
	}

	// post : returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current != null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	// post: appends the given value to the end of the list
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	// pre: 0 <= index <= ()
	// post: inserts the given value at the given index
	public void add(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next);
		}
	}

	// pre : 0 <= index < ()
	// post: removes value at the given index
	public void remove(int index) {
		if (index == 0) {
			front = front.next;
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// pre : 0 <= i < ()
	// post: returns a reference to the node at the given index
	private ListNode nodeAt(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	/**
	 * returns the current number of elements in the list
	 * 
	 * @author BJP5e
	 */
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next; // referent to next node in List
			count++; // increment if not null
		}
		return count;
	}
} // end class

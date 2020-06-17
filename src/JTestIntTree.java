// JTestIntTree.java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*****************************************************************
// ITC155 - Final - Problem 3 - JUnit Tests
// IntTree: isFull method
******************************************************************/


/**
 * @author Nora P.
 * @version 6/16/20
 * Primary test of IntTree method isFull that returns a boolean. True
 * if nodes are either leaves or full branches.
 */
class JTestIntTree {


	@Test
	void testEmptyTree() {
		IntTree empty = new IntTree(); // empty IntTree (1 empty branch e.g. overallRoot)
		assertTrue(empty.isFull());
	}
	
	@Test 
	void testSingleNodeTree() {
		IntTree root = new IntTree(1);
		assertTrue(root.isFull()); // True since there are no branches off of root
	}
	

	@Test
	/**
	 * Tests an IntTree with 12 nodes - one node that has a single branch will test false
	 */
	void testSequencialTree() {
		IntTree sequence = new IntTree(12);
		assertFalse(sequence.isFull());
	}
	
	@Test 
	/**
	 * Smaller tree with 3 values, root with two branches and no additional
	 */
	void testSmallTree() {
		IntTree full = new IntTree(3);
		assertTrue(full.isFull());
	}
	
	
}

//IntTree.java
/**
 * @author Nora P.
 * @version 6/16/20
 * @see http://www.buildingjavaprograms.com/code-files/5ed/ch17/IntTree.java
 */
public class IntTree {
	private IntTreeNode overallRoot;

	/**
	 * Constructs a sequential tree starting at 1 with the given number of nodes
	 * 
	 * @param max The maximum number of nodes in the tree to construct
	 */
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}

		overallRoot = buildTree(1, max);
	}

	/**
	 * Recursive helper method for adding intTree nodes by sequential value
	 * 
	 * @param n
	 * @param max
	 * @return The constructed sequential IntTree
	 */
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
		}
	}

	/**
	 * Post: Constructs an empty tree
	 */
	public IntTree() {
		overallRoot = null;
	}

	public void add(int value) {
		overallRoot = add(overallRoot, value);
	}

	/**
	 * Constructs a Node with the given value and adds it to the given tree
	 * 
	 * @param root  The tree root to attach the new Node
	 * @param value The data value for the new Node to be added
	 * @return The modfied, larger IntTree functional as a binary search tree
	 */
	private IntTreeNode add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
		} else if (value <= root.data) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return root;
	}
	
	/**
	 * @author Nora P.
	 * @return
	 */
	public boolean isFull() {
		return isFull(overallRoot);
	}
	
	/**
	 * @author Nora P.
	 * Evaluates an IntTree based on 'fullness' of branches
	 * @param root The tree to evaluate
	 * @return True if every node has 0 or 2 children
	 */
	private boolean isFull(IntTreeNode root) {
		if (root == null) {
			// Base case: By definition, the empty tree is considered full.
			 return true;
		} else if (root.left != null && root.right == null) {  
			return false; // right branch is empty, e.g. tree is not full
		} else if (root.right != null && root.left == null) {
			return false; // left branch is empty, e.g. tree is not full
		} else {
			// recursive case: else statement recursively checks both left/right 
			// 				   branches - based on above checks, they do exist
			// 				   eventually the base case above will be reached when the final pass
			//				   to isFull is a leaf. If both left / right branches reach the base case
		    // 				   the final statement will return true.
			return isFull(root.left) && isFull(root.right);
		}
	} // end isFull
	
	//////////////// BJP5 METHODS //////////////////
	// post: prints the tree contents, one per line, following an
	// inorder traversal and using indentation to indicate
	// node depth; prints right to left so that it looks
	// correct when the output is rotated.
	public void printSideways() {
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	// root, indenting each line to the given level
	private void printSideways(IntTreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}

}

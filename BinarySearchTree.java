


public class BinarySearchTree {
	private BinaryNode root; // holds root of BST
	
	
	
	public BinarySearchTree() {
		root = null; // initialize root to null
	}

	
	
	public  void add(int entry) {
		if(root == null) {
			root = new BinaryNode(entry);// if root is null, first integer is root
		}
		addEntry(root, entry);
	}
	// adds entry into binary search tree
	private void addEntry(BinaryNode topNode, int Entry) {
		
		int data = topNode.getData();
		if(Entry == data) { // checks if entry == topnode data
			topNode.setData(Entry);
		}else if(Entry < data) {// checks if entry is less that topnode
			if( topNode.hasLeftChild()) {// if topnode has left child, recursively call function with topnode's left child
				addEntry(topNode.getLeftChild(), Entry);
			}else {// else creates new left child with entry as its data
				topNode.setLeftChild(new BinaryNode(Entry));
				
			}
		}else {// checks if entry is greater than topnode
			assert Entry > data;
			if( topNode.hasRightChild()) {//if topnode has right child, recursively call function with topnode's right child
				 addEntry(topNode.getRightChild(), Entry);
			} else {// else creates new right child with entry as its data
				topNode.setRightChild(new BinaryNode(Entry));
				
			}
		}
		
	}
	public void insert(int entry) {
		if(root == null) {
			root = new BinaryNode(entry);
		}
		insertEntry(root, entry);
	}
	// same as add method but is used in the insert command to print statements if node already exists and to print inorder of tree after a node has been inserted
	private void insertEntry(BinaryNode topNode, int Entry) {
		//assert root != null;
		int data = topNode.getData();
		if(Entry == data) {
			System.out.println(Entry + " already exists, ignore.");
			topNode.setData(Entry);
		}else if(Entry < data) {
			if( topNode.hasLeftChild()) {
				insertEntry(topNode.getLeftChild(), Entry);
			}else {
				topNode.setLeftChild(new BinaryNode(Entry));
				System.out.print("In-Order: ");
				inorderTraversing();
				System.out.println();
				
			}
		}else {
			assert Entry > data;
			if( topNode.hasRightChild()) {
				 insertEntry(topNode.getRightChild(), Entry);
			} else {
				topNode.setRightChild(new BinaryNode(Entry));
				System.out.print("In-Order: ");
				inorderTraversing();
				System.out.println();
			}
		}
		
	}
	
	public  void preorderTraversing() { 
		
		PreorderTraversing(root);// calls private method with paramenters
}
	/**
	 * 
	 * @param firstNode
	 */
	private void PreorderTraversing(BinaryNode firstNode) { // preorder traversal using recursion
		
		if(firstNode != null) {
			
			System.out.print(firstNode.getData() + " ");// prints data at node
			PreorderTraversing(firstNode.getLeftChild());// recursive call with binarynode's left child
			PreorderTraversing(firstNode.getRightChild());// recursive call with binarynode's right child
		}
	}
	
	public void inorderTraversing() {
		
		InorderTraversing(root);
	}
	/**
	 * 
	 * @param firstNode
	 */
	private void InorderTraversing(BinaryNode firstNode) { // inorder traversal using recursion
		if(firstNode != null) {
			InorderTraversing(firstNode.getLeftChild());
			System.out.print(firstNode.getData() + " ");
			InorderTraversing(firstNode.getRightChild());
		}
	}
	
	public void postorderTraversing() {
		PostorderTraversing(root);
	}
	/**
	 * 
	 * @param firstNode
	 */
	private void PostorderTraversing(BinaryNode firstNode) {// postorder traversal using recursion
		if(firstNode != null) {
			PostorderTraversing(firstNode.getLeftChild());
			PostorderTraversing(firstNode.getRightChild());
			System.out.print(firstNode.getData() + " ");
		}
	}
	
	
	
	// public remove method
	public  BinaryNode remove( int entry) {
		return removeEntry(root, entry);
	}
	// private remove method
	private  BinaryNode removeEntry(BinaryNode topNode, int entry) {
		// four cases: the entry has two children, the entry is a leaf, the entry has one child, the entry has two children
		// couldn't understand how to code it
		if( topNode == null) {
			return null;
		} 
		if (entry < topNode.getData()) {
			topNode.setLeftChild(removeEntry(topNode.getLeftChild(), entry));
		} else if(entry > topNode.getData()) {
			topNode.setRightChild(removeEntry(topNode.getRightChild(), entry));
		}else {
				if(topNode.getLeftChild() == null && topNode.getRightChild() == null) {// checks if node is a leaf
				return null;
			} else if(topNode.getLeftChild() == null) { //checks if node doesn't have a left child
				return topNode.getRightChild();
			} else if(topNode.getRightChild() == null) {// checks if node doesn't have a right child
				return topNode.getLeftChild();
			} else {
				int successor = swapSuccessor(topNode.getRightChild()); // swaps parent node with successor in right subtree
				topNode.setData(successor); // swaps the node and its successor
				topNode.setRightChild(removeEntry(topNode.getRightChild(), successor)); // deletes node (either a leaf or a parent with one child)
				
			}
		}

		
	return topNode;
	//return result;
	}
	// finds successor to the entry that needs to be deleted
	private int swapSuccessor(BinaryNode tNode) {
		if(tNode.getLeftChild() != null) { // finds leftost child in right subtree
			return swapSuccessor(tNode.getLeftChild()); // recursively " "
		} 
		return tNode.getData();
	}
	// public method get entry
	public BinaryNode getEntry(int entry) {
		
		return entryToFind(root, entry);	
		
	}
	// private method entry To Find
	private BinaryNode entryToFind(BinaryNode root, int entry) {// find entry private method
		BinaryNode result = null;//sets results to null
		if(root != null) { // if tree is not empty
			int entryRoot = root.getData();// sets the root data to the variable entryRoot
			if(entry == entryRoot) {//if equal, returns node
				result = root;
				root.setData(entryRoot);
				
			} else if(entry < entryRoot) { // if entry is less than "root", call recursive function again
				result = entryToFind( root.getLeftChild(), entry);// recursive calls to find entry
			}else { // if entry is greater than "root", call recursive function again
				result = entryToFind(root.getRightChild(), entry);// recursive calls to find entry
				
			}
			
		}
		return result;// if entry not found, return null
	}
	
	// public predecessor method
	public BinaryNode predecessor(int entry) {
		return Predecessor(root, entry);
		
		
	}
	//private leftmost in the right subtree
	public BinaryNode leftmostRightSub(BinaryNode node) {
		BinaryNode result = null;
		if(node.getLeftChild() != null) { // if node has a left child
			result = leftmostRightSub(node.getLeftChild()); // recursive call with node's left child
		}else { // if not, node is the leftmost right 
			result = node;
				
		}
		
		return result;
	}
	// find the rightmost in the left subtree
	public BinaryNode rightmostLeftSub(BinaryNode node) {
		BinaryNode result = null;
		if(node.getRightChild() != null) { // if node has a right child
			result = rightmostLeftSub(node.getRightChild());// recursive call with node;s right child
		} else {// if not, node is the rightmost left
			result = node;
		}
		return result;
	
	} 
	 //private predecessor method
	private BinaryNode Predecessor(BinaryNode root, int entry) {
		BinaryNode node = null;
		BinaryNode predecessor = null;
		if( getEntry(entry) == null) { // id entry is not found
			 node = getEntry(entry);// return null
			return node;
		}else if(getEntry(entry) != null) { // if entry was found
			node = getEntry(entry);// make node equal to entry
			if(node.getLeftChild() != null) { // if node has a left child
				predecessor = rightmostLeftSub(node.getLeftChild());// call method to find rightmost in left subtree 
			} else { // if node does not have left child, find parent
				BinaryNode parent = parent(node);
				predecessor = parent; // predecessor is the parent , i don't know how to fix this one problem here
			}
		
			
		}
		return predecessor;
	}
	// public successor method
	public BinaryNode successor(int entry) {
		return Successor(root, entry);
	}
	// private successor method
	private BinaryNode Successor(BinaryNode root, int entry) {
		BinaryNode node = null;
		BinaryNode successor = null;
		if(getEntry(entry) == null) {
			return node;// return null if entry was not found
		} else if(getEntry(entry) != null) {
			node = getEntry(entry);// if entry was found, node equals entry
			if(node.getRightChild() != null) { // if node's right child does not equal null 
				successor = leftmostRightSub(node.getRightChild());// call leftmost right method to find leftmost node
				
			} else 	{ // if node does not have right child, find parent
				BinaryNode parent = parent(node);
				successor = parent; // successor is the parent
			}
		
		}
		return successor;
	}
	// find the parent of given node/ entry in BST
	public BinaryNode parent(BinaryNode node) {
		return Parent(root, node);
	}
	
	private BinaryNode Parent(BinaryNode topNode, BinaryNode child) {
		BinaryNode result = null;
		int data = child.getData();
		if(topNode.getData() == data) { // if child == root, return null
			return result;
		} else if( data < topNode.getData()) { // if child < root
			BinaryNode left = topNode.getLeftChild(); // create a left binary node
			if(data == left.getData()) { // check if child == root's left child
				result = topNode; // return root if it is
			} else {// if not call recursive function with root's left child as "root"
				result = Parent(topNode.getLeftChild(), child);
			}
		} else { // if child > root
			BinaryNode right = topNode.getRightChild(); // create a right child binary node
			if(data == right.getData()) { // check if child == root's right child
				result = topNode; // if true, return root
			} else {// if not, call recursive function with root's right child as "root"
				result = Parent(topNode.getRightChild(), child);
			}
		}
		return result; // return result
	}


	
	
}


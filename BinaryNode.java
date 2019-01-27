/*BinaryNode class
 * 
 */
public class BinaryNode {
	private  int data;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	
	public BinaryNode( int data) {
		
		this(data, null, null);
		
	}

	
	public  BinaryNode( int data, BinaryNode leftChild, BinaryNode rightChild) {
	
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	
	
	public int getData() {
		return data;
	}
	
	public BinaryNode getLeftChild() {
		return leftChild;
	}
	
	public BinaryNode getRightChild() {
		return rightChild;
	}
	
	public  void setData(int newData) {
		data = newData;
	}
	
	public void setRightChild(BinaryNode newRightChild) {
		rightChild = newRightChild;
	}
	
	public void setLeftChild( BinaryNode newLeftChild) {
		leftChild = newLeftChild;
	}
	
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;

	}
}

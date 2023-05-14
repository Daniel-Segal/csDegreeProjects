/** 
 * Represents a generic node in a generic linked list.
 */
public class Node<T> {
	T t;            // The T object that this node refers to
	Node<T> next;   // The Node object that this node refers to
	
	/** 
	 * Constructs a generic node that refers to the given element.
	 * @param t the element.
	 */
	public Node(T t) {
		this.t = t;
		this.next = null;
	}
	/** 
	 * Constructs a generic node that refers to the next element.
	 * @param t the element.
	 * @param next the next node.
	 */
	public Node(T t, Node<T> next) {
		this.t = t;
		this.next = next;
	}
	
	/** 
	 * Returns a textual representation of the element that this node refers to,
	 * by calling the toString() method of the element.
	 */
	public String toString() {
		return t.toString();
	}
}
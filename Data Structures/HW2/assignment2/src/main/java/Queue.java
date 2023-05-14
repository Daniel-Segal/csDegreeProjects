

/**
 * The Queue class represents a first-in-first-out (FIFO) queue of elements.
 * It supports adding elements to the end of the queue, removing elements from
 * the beginning of the queue, and retrieving the element at the beginning of the queue.
 * @param <T> the type of elements in the queue (generic).
 */
public class Queue <T> {

    private Node<T> first;  // Points to the first node in the queue (just after the dummy node).
	private Node<T> last;   // Points to the last node in the queue.
	private int size;       // Number of queue elements.

	/**
	 * Construcs a Queue of size 0.
	 */
    public Queue() {
		// Starts with a dummy node, to avoid handling empty queues.
		Node<T> dummy = new Node<T>(null);
		this.first = dummy;
		this.last = first;
		this.size = 0;
    }
	/**
	 * Adds an element to the end of the queue.
	 * @param t the element to add.
	 */
    public void add(T t) {
		Node<T> newNode = new Node<T>(t);
		if (this.size == 0) {
			this.first.next = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		this.size++;
	}
	/**
	 * Removes the first occurrence of an element from the queue, if present.
	 * If the queue is empty or the element is not found, does nothing.
	 * @param t the element to remove.
	 */
    public void remove(T t) {
		try {											
			Node<T> prev = first;
			Node<T> current = first.next;

			for(int i = 0; i < size; i++) {
				if(current.t.equals(t)) {
					prev.next = current.next;
					if(i == size - 1) this.last = prev;
					this.size--;
					return;
				}
				current = current.next;
				prev = prev.next;
			}
		}
		catch (NullPointerException e) {
			System.out.println("The Queue is empty");
		}
	}
	/**
	 * Retrieves and removes the element at the beginning of the queue.
	 * If the queue is empty, returns null.
	 * @return the first element in the queue, or null if the queue is empty.
	 */
    public T get() {
		try {
        Node<T> temp = this.first.next;
        this.first.next = this.first.next.next;
        return temp.t;
		}
		catch (NullPointerException e) {
			System.out.println("The list is empty");
			return null;
		}

    }
}

/**
 * The Manager class is used to manage elements by both creation time and priority.
 * It uses a Heap to manage elements by priority and a Queue to manage elements by creation time.
 * @param <T> the type of the elements managed by this Manager.
 */
 public class Manager<T extends Comparable<T>> {

    private Heap<T> heap;   // The heap used to manage elements  by priority.   
    private Queue<T> queue; // The Queue used to manage elements by creation time.
    private int size;       // The current size of Manager

    /**
     * Constructs a Manager with a maximum capacity of 100.
     */
    public Manager() {
        this.heap = new Heap<T>();
        this.queue = new Queue<T>();
        this.size = 0;
    }
    /**
     * Adds an element to this Manager.
     * @param t the element to add.
     */
    public void add(T t) {
        this.heap.add(t);
        this.queue.add(t);
        this.size++;
    }
    
    /** 
     * Retrieves the element with the earliest creation time from this Manager and removes it.
     * @return the element with the earliest creation time.
     */
    public T getByCreationTime() {
        T temp = (T) this.queue.get();
        this.heap.remove(temp);
        this.size--;
        return temp;  
    }
    
    /** 
     * Retrieves the element with the highest priority from this Manager and removes it.
     * @return the element with the highest priority.
     */
    public T getByPriority() {
        T temp = (T) this.heap.get();
        this.queue.remove(temp);
        this.size--;
        return temp;   
    }

    /**
     * @return the size of this Manager.
     */
    public int getSize() {
        return this.size;
    }
}

/**
 * This class represents a max heap.
 *  It is implemented using an array of generic type elements.
 * @param <T> The type of elements in the heap, which must be comparable. 
 */
public class Heap<T extends Comparable<T>> {

    private T[] maxHeap;    // Array of type T that holds the heap elements.
    private int size;       // Number of elements in the heap.
    
    /**
     * Constructs a new max heap with the specified maximum size.
     * @param maxSize The maximum size of the heap.
     */
    public Heap() {
        this.maxHeap = (T[]) new Comparable[100];
        this.size = 0;
        this.maxHeap[0] = null;
    }
    /**
     * Swaps two elements in the max heap.
     * @param index1 The index of the first element to swap.
     * @param index2 The index of the second element to swap.
     */
     private void swap(int index1 , int index2) {
        T temp = this.maxHeap[index1];
        this.maxHeap[index1] = this.maxHeap[index2];
        this.maxHeap[index2] = temp;
    }
    /**
     * Moves an element up the heap until it satisfies the max heap property.
     *  @param index The index of the element to move up.
     */
    private void percUp(int index) {
        if(index == 1) return;
        while(this.maxHeap[index].compareTo(this.maxHeap[index / 2]) > 0) {     // If element at index @index is bigger than his parent swap them.
            swap(index , index / 2);                    
            index = index / 2;                                                  // Updates the index.
            if(index == 1) return;
        }
    }

    /**
     * Adds an element to the max heap.
     * @param t The element to add.
     */
    public void add(T t) {
        if(size == this.maxHeap.length - 1) expandArray();
        this.maxHeap[size + 1] = t;
        this.size++;
        percUp(size);
        
    }

   /**
    * Doubles the array size.
    */
    private void expandArray() {
        T[] temp = (T[]) new Comparable[this.maxHeap.length * 2];
        for(int i = 0; i < maxHeap.length; i++) temp[i] = this.maxHeap[i];
        this.maxHeap = temp;
    }

    /**
     * Moves an element down the max heap until it satisfies the max heap property.
     * @param index The index of the element to move down.
     */
    private void percDown(int index) {

        while(2 * index < this.size) {                 // Has two childs. 

            int leftChildIndex = index * 2;
            int rightChildIndex = index * 2 + 1;
            int biggerChildIndex = leftChildIndex;     // Assumes at first that the left child is bigger. 

            if(this.maxHeap[leftChildIndex].compareTo(this.maxHeap[rightChildIndex]) < 0)
            biggerChildIndex = rightChildIndex;        // Compares both childs and updates the bigger child if needed. 

            if(this.maxHeap[index].compareTo(this.maxHeap[biggerChildIndex]) < 0)      // If child at index @index bigger than his parent swaps them. 
            {
            swap(index, biggerChildIndex);
            index = biggerChildIndex;
            }
            else return;       
        }
        if(2 * index == this.size) {    // Has one child.
            if(this.maxHeap[index].compareTo(this.maxHeap[2 * index]) < 0) 
            swap(index, index * 2);
            return;
        }
        if(2 * index > this.size) return;   // Is a leaf.
    }

    /**
	 * Removes the first occurrence of an element from the heap, if present, and percolating down.
	 * If the heap is empty or the element is not found, does nothing.
	 * @param t the element to remove.
	 */
    public void remove(T t) {
        for(int i = 1; i <= this.size; i++) {
            if(this.maxHeap[i].compareTo(t) == 0)
            { 
            this.maxHeap[i] = this.maxHeap[this.size];
            this.maxHeap[this.size] = null;
            this.size--;
            percDown(i);
            return;
            }
        }
    }

    /**
	 * Retrieves and removes the element at the top of the heap.
	 * If the heap is empty, returns null.
	 * @return the top element in the heap, or null if the heap is empty.
	 */
    public T get() {
        T temp = this.maxHeap[1];
        this.maxHeap[1] = this.maxHeap[this.size];
        this.maxHeap[this.size] = null;
        this.size--;
        percDown(1);
        return temp;
    }

    /**
     * @return the heap size.
     */
    public int getSize() {
        return this.size;
    }
}

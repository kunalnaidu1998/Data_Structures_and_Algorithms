import java.util.Iterator;

/**
 *  Creates a Double Linked List
 * @param <T>
 */
public class DLList<T> implements Iterable<T>{

    // create start and end position
    DoublyLinkedNode<T> start ;
    DoublyLinkedNode<T> end  ;

    int theSize;

    int modCount = 0;

    /**
     * takes an inputted array and converts the requested amount of values to an DLList
     * @param array
     * @param n
     */
    public DLList(T[] array, int n){
        // initialize DDList
        start = new DoublyLinkedNode<>(null, null, null);
        end = new DoublyLinkedNode<>(null, start, null);
        start.setNext(end);

        theSize = 0;
        modCount ++;

        // add n values from array to DDList
        for (int i = 0; i < n; i++){
            add(array[i]);
        }

    }

    /**
     * returns the size of the list
     * @return int list size
     */
    public int size() {
        return theSize;
    }

    /**
     * add value to DDList to end of list
     * @param x value to add
     * @return true or false if add is successful
     */
    public boolean add(T x){
        add(size(), x);
        return true;
    }

    /**
     * add value to DDList to position x of the list
     *
     * @param idx index to be added
     * @param x  value to be added
     */
    public void add(int idx, T x){
        addBefore( getNode(idx, size()), x);
    }

    /**
     * adds the value before the node p
     *
     * @param p node to be added before
     * @param x value to be added
     */
    private void addBefore(DoublyLinkedNode<T> p, T x){
        // fit node into list
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(x, p.getPrevious(), p);
        newNode.getPrevious().setNext(newNode);
        p.setPrevious(newNode);

        // increment
        theSize++;
        modCount++;

    }

    /**
     * gets the node at the index
     *
     * @param idx
     * @return get node that input indx  and the upper limit
     */
    private DoublyLinkedNode<T> getNode(int idx){
        return getNode(idx, size() - 1);
    }

    /**
     *  gets the node at the index
     * @param idx index of node
     * @param upper upper limit of list
     * @return node at the index
     */
    private DoublyLinkedNode<T> getNode(int idx, int upper){
        DoublyLinkedNode<T> p;

        // if index is out of bounds of list
        if (idx < 0 || idx > upper){
            throw new IndexOutOfBoundsException();
        }

        // if list is on the lower half of list else on upper half
        if (idx < size() / 2){
            p = start.getNext();
            for (int i=0; i < idx; i++){
                p = p.getNext();
            }
        } else {
            p = end;
            for (int i = size(); i > idx; i--){
                p = p.getPrevious();
            }
        }
        return p;
    }

    /**
     * initializes itterator
     *
     * @return instance of itterator
     */
    public java.util.Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    /**
     * Iterator for the DDList
     */
    private class LinkedListIterator implements java.util.Iterator<T>{
        private DoublyLinkedNode<T> current = start.getNext();
        private final int expectedModCount = modCount;

        private boolean okToRemove = false;

        /**
         * checks if there is a next value
         * @return checks if there is next value
         */
        public boolean hasNext(){
            return current != end;
        }

        /**
         * gives you the next value in the list
         *
         * @return the next value in list
         */
        public T next(){
            // check if modifications where made during iteration
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            // check if there is a next value
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            // get next value and return
            T nextItem = current.getData();
            current = current.getNext();
            okToRemove = true;
            return nextItem;
        }

        /**
         *  checks to see if there is a previous value
         * @return
         */
        public boolean hasPrevious(){
            return current != start;
        }

        /**
         * gives the previous value in the list
         * @return the previous value
         */
        public T previous(){
            // check if modification between iteration
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            // check if there is a previous value
            if(!hasPrevious()){
                throw new java.util.NoSuchElementException();
            }

            // get previous value and return
            T previousItem = current.getData();
            current = current.getPrevious();
            okToRemove = true;
            return previousItem;
        }
    }

    /**
     * finds the frequency of a given element
     *
     * @param element element to check the frequency of
     * @return the number of times a element has appeared
     */
    public int frequency(T element){
        // initialize iterator
        Iterator<T> itr = this.iterator();

        // count occurrences
        int count = 0;
        while(itr.hasNext()){
            if (itr.next() == element){
                count ++;
            }
        }
        return count;
    }

    /**
     * checks to see if the elements of the DLList are palindrome
     * @return true or false if the list is a palindrome
     */
    public boolean palindrome(){
        // initialize start and end of the list
        DoublyLinkedNode<T> p = start.getNext();
        DoublyLinkedNode<T> q = end.getPrevious();

        // reduce q and increase p and check to see if they are the same
        int counter = 0;
        while (p.getData() == q.getData() && counter < size()){
            p = p.getNext();
            q = q.getPrevious();
            counter ++;
        }
        return counter == size() ;
    }
}

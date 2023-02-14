import java.util.LinkedList;

/**
 * creates a stack object of a list of elements
 * @param <T>
 */
public class CS319Stack<T> {

    int topOfStack;

    LinkedList<SingleyLinkedNode<T>> stack = new LinkedList<>();

    public CS319Stack(){
        this.topOfStack = -1;
    }

    /**
     * inserts a new element onto the stack
     *
     * @param element : element to be added
     */
    public void push(T element){
        // create new node
        SingleyLinkedNode<T> newElement = new SingleyLinkedNode<T>(element);

        // if stack is empty add else add and set next value from previous element
        if (topOfStack == -1){
            // add new element
            stack.add(newElement);
        } else{
            // top node
            SingleyLinkedNode<T> topElement = stack.get(topOfStack);


            // set next for top node
            topElement.setNext(newElement);

            // add new node to stack
            stack.add(newElement);
        }
        // increment stack
        this.topOfStack ++;
    }

    /**
     * removes the top element from the stack
     */
    public void pop(){
        stack.removeLast();
        topOfStack--;

        // set next of last item to null
        stack.getLast().setNext(null);
    }

    /**
     * returns the top element of the stack without removing it
     * @return : top element of the stack
     */
    public T peek(){
        return stack.getLast().getData();
    }

    /**
     * check if the stack is empty
     * @return : boolean on if the stack is empty
     */
    public boolean is_empty(){
        if (this.topOfStack == -1){
            return true;
        } else{
            return false;
        }
    }

    /**
     * returns the current size of the stack
     * @return : int of the size of the stack
     */
    public int size(){
        return topOfStack;
    }
}

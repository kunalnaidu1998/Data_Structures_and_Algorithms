public class DoublyLinkedNode<T> {
    private T data;
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;
    public DoublyLinkedNode(T theData){
        data = theData;
        previous = null;
        next = null;
    }
    public DoublyLinkedNode(T theData, DoublyLinkedNode<T> thePrevious, DoublyLinkedNode<T> theNext){
        data = theData;
        previous = thePrevious;
        next = theNext;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

}

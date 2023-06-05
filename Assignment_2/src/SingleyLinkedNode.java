public class SingleyLinkedNode<E>{
    E data;
    SingleyLinkedNode<E> next;
    public SingleyLinkedNode(E theData, SingleyLinkedNode<E> theNext){
        data = theData;
        next = theNext;
    }
    public SingleyLinkedNode(E theData){
        data = theData;
        next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public SingleyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(SingleyLinkedNode<E> next) {
        this.next = next;
    }
}
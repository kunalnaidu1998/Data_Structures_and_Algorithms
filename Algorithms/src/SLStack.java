public class SLStack <T> {
    public Node<T> top;
    public int size = 0;

    private class Node<T>{
        public T data;
        public Node<T> next;

        public Node(T data,Node<T> next){
            this.data = data;
            this.next = next;
        }
    }
    public void push(T element){
        if (size == 0) top = new Node<>(element, null);
        else{
            Node<T> newNode = new Node<>(element, top.next);
            top = newNode;
        }
        size++;
    }
    public T pop(){
        Node<T> temp = top;
        top = temp.next;
        return temp.data;
    }

    public T peek(){
        return top.data;
    }
}

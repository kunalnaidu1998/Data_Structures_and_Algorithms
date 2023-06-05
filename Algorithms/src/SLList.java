public class SLList <T> {

    public Node<T> head;
    public Node<T> tail;
    public int size = 0;
    private class Node <T>{
        public Node<T> next;
        public T data;

        public Node(T data, Node<T> next){
            this.next = next;
            this.data = data;
        }
    }
    public void add(int index, T data){
        if (size == 0){
            head = tail = new Node<>(data, null);
            size ++;
        }
        else{
            Node<T> trav = head;
            for (int i = 0; i < index; i++){
                trav = trav.next;
            }
            Node<T> newNode = new Node<>(data, trav.next);
            trav.next = newNode;
            size++;
        }
    }
    public void add(T data){
        if (size == 0){
            head = tail = new Node<>(data, null);
            size++;
        }
        else{
            Node<T> newNode = new Node<>(data, null);
            tail.next = newNode;
            tail = newNode;
            size++;

        }
    }

    public void remove(int index){
        Node<T> trav1 = head;
        Node<T> trav2 = head.next.next;

        for (int i = 0; i < index; i++){
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        Node<T> temp = trav1.next;
        trav1.next = trav2;
        temp.next = null;

    }
}

public class DLList <T>{
    public Node<T> head;
    public Node<T> tail;
    public int size = 0;

    private class Node<T>{
        T data;
        Node<T> previous, next;

        public Node(T data, Node<T> previous, Node<T> next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }


    public void add(int index, T data){

        if (head == null){
            head = tail = new Node<>(data, null, null);
            size ++;
        }
        else{
            Node<T> trav = head;
            for (int i = 0; i < index; i++){
                trav = trav.next;
            }
            Node<T> newNode = new Node<>(data, trav, trav.next);
            newNode.previous.next = newNode;
            newNode.next.previous = newNode;
            size ++;
        }

    }
    public void add(T data){
        if (head == null){
            head = tail = new Node<>(data, null, null);
            size ++;
        }
        else{
            Node<T> newNode = new Node<>(data, tail, null);
            newNode.previous.next = newNode;
            tail = newNode;
            size ++;
        }

    }

    public T get(int index){

        Node<T> trav = head;
        for (int i = 0; i <= index; i++) trav = trav.next;

        return trav.data;
    }

    public void remove(int index){
        Node<T> trav = head;
        for (int i = 0; i <= index; i++){
            trav = trav.next;
        }
        trav.previous.next = trav.next;
        trav.next.previous = trav.previous;

        trav.previous = null;
        trav.next = null;
        size --;
    }
}

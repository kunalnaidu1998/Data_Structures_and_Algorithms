public class DynamicArray <T> {

    public T[] arr;
    public int length;
    public int capacity;

    public DynamicArray (int initCapacity){
        arr = (T[]) new Object[initCapacity];
        capacity = initCapacity;
        length = 0;
    }

    public T get(int index) {return arr[index];}

    public void add(int index, T element){

        if (length + 1 > capacity) increaseSize();

        for (int i = length ; i > index; i--) arr[i + 1] = arr[i];

        arr[index] = element;
        length++;
    }

    public void add(T element){
        if (length + 1 > capacity) increaseSize();

        add(length++,element);
    }


    private void increaseSize() {
        int newCapacity = capacity * 2;
        T[] tempArr = (T[]) new Object[newCapacity];

        for (int i = 0; i < capacity; i++) tempArr[i] = arr[i];

        capacity = newCapacity;
        arr = tempArr;
    }
    public void remove(int index){
        for (int i = length; i < index-1; i--) arr[i] = arr[i+1];

        arr[length--] = null;
    }

    public void clear(){
        arr = (T[]) new Object[capacity];
        length = 0;
    }
}

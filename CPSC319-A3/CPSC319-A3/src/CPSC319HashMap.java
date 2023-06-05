import java.util.*;

public class CPSC319HashMap<K, V> {
    private int capacity;
    private float loadFactor;
    private int size;
    ArrayList<LinkedList<Pair<K, V>>> data;
    public CPSC319HashMap(int theCapacity, float theLoadFactor){
        size = 0;
        capacity = theCapacity;
        loadFactor = theLoadFactor;
        data = new ArrayList<>(theCapacity);
        for(int i=0; i < capacity; i++)
            data.add(new LinkedList<Pair<K, V>>());
    }

    public int getCapacity(){
        return capacity;
    }

    /**
     *  the number of values in a hash map
     * @return number of values
     */
    public int size() {
        return size;
    }

    /**
     * checks to see if the hashmap is empty
     * @return true or false if the hashmap is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * checks to see if the hashmap contains the given key
     * @param key : the key to look for
     * @return true or false if the key is in the hashmap
     */
    public boolean containsKey(K key) {

        // if can get value then key exists
        if (get(key) == null){
            return false;
        } else {
            return true;
        }
    }

    /**
     * gets the value for the given key
     * @param key key that you want the value for
     * @return the value for the given key
     */
    public V get(K key) {
        // checks linked list
        LinkedList <Pair<K,V>> list = data.get(getIndex(key));

        // if list is empty
        if (list == null){
            return null;
        }
        // for each value in linked list check if key matches
        for (Pair<K,V> pair : list){
            if (pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    /**
     * add key and value into hashmap
     * @param key key to be added
     * @param value value to be added
     * @return the value that was added
     */
    public V put(K key, V value) {
        // create new pair
        Pair<K,V> newPair = new Pair<>(key, value);

        // find out the index for new pair
        int newIndex = getIndex(key);

        // check if key already exists
        V checkPosition = get(key);
        if (checkPosition == null){
            // add new pair
            data.get(newIndex).add(newPair);
            size ++;
            // make sure load factor is not exceeded
            if (load() > loadFactor){
                increaseData();
            }
            return newPair.getValue();
        // if key already exits
        } else {
            // change value for given key
            for (int i = 0; i < data.get(newIndex).size(); i++){
                if (data.get(newIndex).get(i).getKey() == key){
                    data.get(newIndex).set(i, newPair);
                    break;
                }
            }
            return newPair.getValue();
        }

    }

    /**
     * increases hashmap capacity and remaps the data
     */
    public void increaseData(){
        // double the capacity
        capacity *= 2;

        // create new hashmap
        ArrayList<LinkedList<Pair<K, V>>> newData = new ArrayList<>(capacity);

        // initialize linked lists for all arraylist positions
        for(int i=0; i < capacity; i++)
            newData.add(new LinkedList<Pair<K, V>>());

        // for all arraylist positions
        for (int i = 0; i < data.size(); i++){
            // for each linked list position get the pair
            for (Pair<K,V> pair : data.get(i)){
                // calculate the new index
               int newIndex = getIndex(pair.getKey());
               // add to the new hashmap
               newData.get(newIndex).add(pair);
            }
        }
        data = newData;
    }

    /**
     * remove the pair at the given key
     * @param key the key where the pair is to be removed
     * @return returns the value to be removed
     */
    public V remove(K key) {
        //TODO: Implement this method
        // get linked list
        LinkedList <Pair<K,V>> list = data.get(getIndex(key));

        // if linked list doesnt exist then there is no key there
        if (list == null){
            return null;
        }
        // for each value in the list
        for (Pair<K,V> pair : list){
            // find the relevant key
            if (pair.getKey().equals(key)){
                // remove the key
                data.get(getIndex(key)).remove(pair);
                size --;
                return pair.getValue();
            }
        }
        return null;
    }

    /**
     * hashset of all the keys in the hashmap
     * @return hashset of all the keys in the hashmap
     */
    public Set<K> keySet() {
        //TODO: Implement this method
        HashSet<K> keys = new HashSet<>();
        // go through every position to find each key
        for (LinkedList<Pair<K,V>> list : data){
            for (Pair<K,V> pair : list){
                keys.add(pair.getKey());
            }
        }
        return keys;
    }

    /**
     * hashset of all the values in the hashmap
     * @return hashset of all the keys in the hashmap
     */
    public Collection<V> values() {
        //TODO: Implement this method
        HashSet<V> valuesList= new HashSet<>();
        // for each position get the values for each key
        for (LinkedList<Pair<K,V>> list : data){
            for (Pair<K,V> pair : list){
                valuesList.add(pair.getValue());
            }
        }
        return valuesList;
    }

    /**
     * hashset of all the pairs in the hashmap
     * @return hashset of all the pairs in the hashmap
     */
    public HashSet<Pair<K, V>> entrySet() {
        //TODO: Implement this method
        HashSet<Pair<K, V>> pairs= new HashSet<>();
        // for each position get all the pairs
        for (LinkedList<Pair<K,V>> list : data){
            for (Pair<K,V> pair : list){
                pairs.add(pair);
            }
        }
        return pairs;
    }
    private float load(){
        return this.size/ data.size();
    }

    /**
     * creates string of all the keys and values in the hashmap
     * @return string of all the keys and values in the hashmap
     */
    public String toString(){
        //TODO: Implement this method

        String output = "";
        // go through all the positions to get all the keys and values and convert to string
        for (LinkedList<Pair<K,V>> list : data){
            for (Pair<K,V> pair : list){
                output += pair.getKey().toString() + ":" + pair.getValue().toString() + "\n";
            }
        }
        return output;
    }
    private int getIndex(K key){
        int index = key.hashCode() % capacity;
        if(index < 0)
            index += capacity;
        return index;
    }
}

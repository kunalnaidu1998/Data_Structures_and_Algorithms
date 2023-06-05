import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static CPSC319HashMap<String, Long>  readCSVFile(String filePath){
        ArrayList<Pair<String, Long>> items = new ArrayList<Pair<String, Long>>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String country = tokens[0];
                Long count = Long.parseLong(tokens[1]);
                Pair<String, Long> pair = new Pair(country, count);
                items.add(pair);
            }
            scanner.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CPSC319HashMap<String, Long> population = new CPSC319HashMap<>(16, 0.75F);
        for(Pair<String, Long> p: items){
            population.put(p.getKey(), p.getValue());
        }
        return population;
    }

    /**
     * gets the minimum population of the hashmap
     * @param map : given hashmap
     * @return the pair with the minimum population
     */
    public static Pair<String, Long> findMin(CPSC319HashMap<String, Long> map){
        //TODO: Implement this method

        // find the minimum value in the hashmap
        Long minValue = Collections.min(map.values());
        // actually finding the minimum pair in the hashmap
        for (Pair<String,Long> set : map.entrySet()){
            if (set.getValue() == minValue){
                return set;
            }

        }
        return null;
    }

    /**
     * calculates the sum of the population for the given hashmap
     * @param map : given hashmap
     * @return : the sum of the population
     */
    public static Long populationSum(CPSC319HashMap<String, Long> map){
        Long sum = 0L;
        // take the hashset of the values and sum them all together
        HashSet<Long> data = (HashSet<Long>) map.values();
        for (Long value : data){
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // initialize test hashmap
        CPSC319HashMap<Integer, String> dict = new CPSC319HashMap<>(10, 0.8F);

        // test for isEmpty
        System.out.println("check if initial hashmap is empty: " + dict.isEmpty());

        // insert keys and values
        dict.put(1,"hello");
        dict.put(2, "bye");
        dict.put(3, "cool");

        // test for get
        System.out.println("Test to see if get method gets key 1: " + dict.get(1));

        // test for contains key
        System.out.println("Tests to see if hashmap contains key 1: " + dict.containsKey(1));

        // test to see if size works
        System.out.println("checks to see what the size is after adding 3 keys and values: " + dict.size());

        // test to see if increase data works
        dict.increaseData();
        System.out.println("test to see if key 1 is in the hashmap after increasing capacity of hashmap: " +
                dict.containsKey(1));

        // test to see if remove works
        dict.remove(1);
        System.out.println("checks to see if the remove decreases hashmap size: " + dict.size());
        System.out.println("checks to see if the removed key still exists: " + dict.containsKey(1));

        // testing the key set
        System.out.println("Test to see if all the keys are printed: " + dict.keySet());

        // test the values work
        System.out.println("Test to see if all values are printed: " + dict.values());

        // test to see if the entry set works
        System.out.println("Test to see if the entrysets are printed: " + dict.entrySet());

        // checks to see if to string works
        System.out.println("Check to see if the to string works: \n" + dict.toString());
        //TODO: Implement this method


        String filePath = "population.csv";

        CPSC319HashMap<String, Long> population = readCSVFile(filePath);
        // check to see if find min works
        System.out.println("Minimum Pair was found to be: " + findMin(population));

        // check to see if population sum works
        System.out.println("Sum of the population was calculated to be: " + populationSum(population));
    }



}
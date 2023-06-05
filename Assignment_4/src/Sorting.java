import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Sorting<T extends Comparable<T>> {
    public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> arr) {
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
        return arr;
    }

    /**
     * Takes an arraylist and sorts the values from smallest to largest using the insertion sort method.
     * @param arr - unsorted array to be sorted
     * @return - sorted arraylist
     * @param <T> - object that can be used by Comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> arr) {
        //TODO: Implement this method

        // for each value in the list
        for (int i = 1; i <arr.size(); i++){

            // store the current value and the previous location for future comparisons
            T current = arr.get(i);
            int comparePos = i - 1;

            // make sure that we don't decrement beyond list and check that the previous value is larger
            while ( comparePos >= 0 && arr.get(comparePos).compareTo(current) > 0){
                // shuffle over the larger values
                arr.set(comparePos + 1, arr.get(comparePos));
                // decrement position of comparison
                comparePos--;
            }
            // once finished shuffling put current in appropriate spot
            arr.set(comparePos + 1, current);
        }

        return arr;
    }

    /**
     * Takes an arraylist and uses the bubble sort method to sort the array from smallest value to largest value.
     * @param arr - unsorted arraylist to be sorted
     * @return - sorted arraylist from smallest to largest
     * @param <T> - object that can be used by comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> arr) {
        // for each value in the array
        for (int i = 0 ; i < arr.size(); i++)
            // for each value in the array except the first and the already sorted values
            for (int j = 1; j < arr.size() - i; j++)
                // if the previous value is larger than swap the values
                if (arr.get(j-1).compareTo(arr.get(j)) > 0){
                    T temp = arr.get(j-1);
                    arr.set(j-1, arr.get(j));
                    arr.set(j, temp);
                }
        return arr;
    }


    /**
     * Takes an array list and uses the merge sort method to sort the array from the smallest value to the largest value
     * @param arr : arraylist to be sorted
     * @return : sorted arraylist
     * @param <T> : object that can be used by comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> arr) {

        int size = arr.size();

        // base case where we separate to single value
        if (size <= 1) return arr;

        else {
            // find middle of array
            int middle = size / 2;

            // separate into left and right
            ArrayList<T> left = new ArrayList<>(middle);
            ArrayList<T> right = new ArrayList<>(size - middle);

            // fill values into left and right array from original array
            int i = 0;
            for (; i < middle; i++)
                left.add(arr.get(i));

            for (int j = i; j < size; j++)
                right.add(arr.get(j));

            // seperate all the way down to the left most and then seperate right and then merge all the values
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);

        }
    }

    /**
     *  helper method for mergeSort function which merges values in arrays from smallest to largest
     *
     * @param leftArr : 1st array to be merged
     * @param rightArr : 2nd array to be merged
     * @return : sorted and merged array from the given arrays
     * @param <T> : object that can be used by comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> leftArr, ArrayList<T> rightArr){

        // create frame for merged list
        ArrayList<T> mergedList = new ArrayList<>();

        // calculate sizes of arrays
        int leftSize = leftArr.size();
        int rightSize = rightArr.size();

        // initialize indexing
        int leftIndx = 0;
        int rightIndx = 0;


        // while we can compare left array value to right array value
        while (leftIndx < leftSize && rightIndx < rightSize){
            // compare the values
            int compare = leftArr.get(leftIndx).compareTo(rightArr.get(rightIndx));
            // if left is larger than add right to merged
            if (compare > 0)
                mergedList.add(rightArr.get(rightIndx++));
            // if right is larger than add right to merged
            else
                mergedList.add(leftArr.get(leftIndx++));
        }

        // check for remaining left array values and just add to array
        while (leftIndx < leftSize)
            mergedList.add(leftArr.get(leftIndx++));

        // check for remaining right array values and just add to array
        while (rightIndx < rightSize)
            mergedList.add(rightArr.get(rightIndx++));

        return mergedList;
    }

    /**
     * Takes an array list and uses the quick sort method to sort the array from the smallest value to the largest value
     * @param arr : unsorted array to be sorted using the quick sort method
     * @return : sorted array using the quick sort method
     * @param <T> : object that can be used by comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> quickSort(ArrayList<T> arr) {
        //TODO: Implement this method

        // call recursive quick sort function
        quickSortReccurs(arr, 0, arr.size() - 1);
        return arr;
    }

    /**
     * helper function for quickSort which uses recursion to sort the array using the quickSort
     * @param arr : array to be sorted
     * @param start : start of the section of array to be sorted
     * @param end : end of the section of array to be sorted
     * @param <T> : object that can be used by comparable
     */
    public static <T extends Comparable<T>> void quickSortReccurs(ArrayList<T> arr, int start, int end){

        // check to see we can't divide our array
        if (start < end){
            // sorts our array with respect our pivot and returns the position of our pivot
            int pivotIndx = partition(arr, start, end);
            // recalls quickSortReccurs for the left and right part of our pivot
            // ignores pivot
            quickSortReccurs(arr, start, pivotIndx - 1);
            quickSortReccurs(arr, pivotIndx + 1, end);
        }
    }

    /**
     * helper function for quickSortReccurs which sorts the array and returns the location of the pivot after sorting
     * @param arr : array to be sorted
     * @param start : start of the section of array to be sorted
     * @param end : end of the section of array to be sorted
     * @return : position of pivot after sorting
     * @param <T> : object that can be used by comparable
     */
    public static <T extends Comparable<T>> int partition(ArrayList<T> arr, int start, int end){

        // set the pivot to be the end of the array
        T pivot = arr.get(end);

        // initialize our start to be outside the scope of focus of our current array
        int i = start - 1;

        // iterate from the start to the end of the array
        for (int j = start; j < end; j++){
            // if the value at j is less than the pivot value then
            if (arr.get(j).compareTo(pivot) < 0){
                // increment i and swap position i for position j
                T temp = arr.get(++i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);

            }
        }
        // increment i
        // final location of pivot is i
        // swap index of incremented i with our pivot
        T temp = arr.get(++i);
        arr.set(i, arr.get(end));
        arr.set(end, temp);

        return i;
    }


    /**
     * Takes an array list and uses the heap sort method to sort the array from the smallest value to the largest value
     * @param arr : array to be sorted using the heap sort method
     * @return : sorted array using the heap sort method
     * @param <T> : : object that can be used by comparable
     */
    public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> arr) {
        //TODO: Implement this method

        // create priority cue
        PriorityQueue<T> queue = new PriorityQueue<>();

        // add values from list to queue
        for (int i = 0; i < arr.size(); i++){
            queue.add(arr.get(i));
        }


        ArrayList<T> sorted = new ArrayList<>();

        // poll largest value while list is not empty
        while(!queue.isEmpty()){
            sorted.add(queue.poll());
        }
        return sorted;
    }

    /**
     * Takes an array list of integers and uses the radux sort method to sort the array from
     * the smallest value to the largest value
     *
     * @param arr : unsorted array of Integers
     * @return : sorted array of Integers
     */
    public static ArrayList<Integer> radixSort(ArrayList<Integer> arr){

        // create bins for sorting
        ArrayList<ArrayList<Integer>> bins = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bins.add(new ArrayList<>());

        // increase digit finder times 10 until all integers get grouped in bin 0
        for (int digitFinder = 10; bins.get(0).size() < arr.size(); digitFinder *= 10){

            // clear all bins
            for (int i = 0; i < bins.size(); i++)
                bins.get(i).clear();

            // place value in array in corresponding digit bin
            for (Integer val : arr)
                bins.get((val / (digitFinder / 10)) % digitFinder).add(val);

            // clear array
            arr.clear();

            // repopulate array in order of placement in bins
            for (ArrayList<Integer> bin : bins)
                arr.addAll(bin);

        }

        return arr;
    }

}

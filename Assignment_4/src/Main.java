import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> smallList = generateRandomArrayList(100, 0, 100);
        ArrayList<Integer> mediumList = generateRandomArrayList(10000, 0, 100);
        ArrayList<Integer> largeList = generateRandomArrayList(100000, 0, 100);

        double smallListSelectionSortTime = averageTimeSort(smallList, 10, Sorting::selectionSort);
        System.out.println(
                "Time required to sort the smallList using selectionSort: "
                + smallListSelectionSortTime + " seconds");
        double mediumListSelectionSortTime= averageTimeSort(mediumList, 10, Sorting::selectionSort);
        System.out.println(
                "Time required to sort the mediumList using selectionSort: "
                        + mediumListSelectionSortTime + " seconds");
        double largeListSelectionSortTime = averageTimeSort(largeList, 10, Sorting::selectionSort);
        System.out.println(
                "Time required to sort the largeList using selectionSort: "
                        + largeListSelectionSortTime + " seconds");
        //TODO: Measuring the running times for the requested sort algorithms.

        // bubble sort

        double smallListBubbleSortTime = averageTimeSort(smallList, 10, Sorting::bubbleSort);
        System.out.println(
                "Time required to sort the smallList using bubbleSort: "
                        + smallListBubbleSortTime + " seconds");
        double mediumListBubbleSortTime= averageTimeSort(mediumList, 10, Sorting::bubbleSort);
        System.out.println(
                "Time required to sort the mediumList using bubbleSort: "
                        + mediumListBubbleSortTime + " seconds");
        double largeListBubbleSortTime = averageTimeSort(largeList, 10, Sorting::bubbleSort);
        System.out.println(
                "Time required to sort the largeList using bubbleSort: "
                        + largeListBubbleSortTime + " seconds");


        // insertion sort

        double smallListInsertionSortTime = averageTimeSort(smallList, 10, Sorting::insertionSort);
        System.out.println(
                "Time required to sort the smallList using insertionSort: "
                        + smallListInsertionSortTime + " seconds");
        double mediumListInsertionSortTime= averageTimeSort(mediumList, 10, Sorting::insertionSort);
        System.out.println(
                "Time required to sort the mediumList using insertionSort: "
                        + mediumListInsertionSortTime + " seconds");
        double largeListInsertionSortTime = averageTimeSort(largeList, 10, Sorting::insertionSort);
        System.out.println(
                "Time required to sort the largeList using insertionSort: "
                        + largeListInsertionSortTime + " seconds");



        // merge sort

        double smallListMergeSortTime = averageTimeSort(smallList, 10, Sorting::mergeSort);
        System.out.println(
                "Time required to sort the smallList using mergeSort: "
                        + smallListMergeSortTime + " seconds");
        double mediumListMergeSortTime= averageTimeSort(mediumList, 10, Sorting::mergeSort);
        System.out.println(
                "Time required to sort the mediumList using mergeSort: "
                        + mediumListMergeSortTime + " seconds");
        double largeListMergeSortTime = averageTimeSort(largeList, 10, Sorting::mergeSort);
        System.out.println(
                "Time required to sort the largeList using mergeSort: "
                        + largeListMergeSortTime + " seconds");




         // quick sort
        
         double smallListQuickSortTime = averageTimeSort(smallList, 10, Sorting::quickSort);
         System.out.println(
         "Time required to sort the smallList using quickSort: "
         + smallListQuickSortTime + " seconds");
         double mediumListQuickSortTime= averageTimeSort(mediumList, 10, Sorting::quickSort);
         System.out.println(
         "Time required to sort the mediumList using quickSort: "
         + mediumListQuickSortTime + " seconds");
         double largeListQuickSortTime = averageTimeSort(largeList, 10, Sorting::quickSort);
         System.out.println(
         "Time required to sort the largeList using quickSort: "
         + largeListQuickSortTime + " seconds");




        // heap sort

         double smallListHeapSortTime = averageTimeSort(smallList, 10, Sorting::heapSort);
         System.out.println(
         "Time required to sort the smallList using heapSort: "
         + smallListHeapSortTime + " seconds");
         double mediumListHeapSortTime= averageTimeSort(mediumList, 10, Sorting::heapSort);
         System.out.println(
         "Time required to sort the mediumList using heapSort: "
         + mediumListHeapSortTime + " seconds");
         double largeListHeapSortTime = averageTimeSort(largeList, 10, Sorting::heapSort);
         System.out.println(
         "Time required to sort the largeList using heapSort: "
         + largeListHeapSortTime + " seconds");






         // radix sort
        double smallListRadixSortTime = averageTimeSort(smallList, 10, Sorting::radixSort);
        System.out.println(
                "Time required to sort the smallList using radixSort: "
                        + smallListRadixSortTime + " seconds");
        double mediumListRadixSortTime= averageTimeSort(mediumList, 10, Sorting::radixSort);
        System.out.println(
                "Time required to sort the mediumList using radixSort: "
                        + mediumListRadixSortTime + " seconds");
        double largeListRadixSortTime = averageTimeSort(largeList, 10, Sorting::radixSort);
        System.out.println(
                "Time required to sort the largeList using radixSort: "
                        + largeListRadixSortTime + " seconds");


        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(3);

        Sorting<Integer> sort = new Sorting<>();

        System.out.println(sort.radixSort(arr));
    }

    /**
     * Generates an ArrayList of random integers.
     *
     * @param size      The size of the ArrayList to be generated.
     * @param minValue  The minimum value of the integers (inclusive).
     * @param maxValue  The maximum value of the integers (exclusive).
     * @return          The generated ArrayList of random integers.
     */
    public static ArrayList<Integer> generateRandomArrayList(int size, int minValue, int maxValue) {
        ArrayList<Integer> randomList = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber = minValue + random.nextInt(maxValue - minValue);
            randomList.add(randomNumber);
        }

        return randomList;
    }
    public static long measureAverageTime(Runnable runnable, int repetitions) {
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            long startTime = System.nanoTime();
            runnable.run();
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / repetitions;
    }

    public static double averageTimeSort(ArrayList<Integer> list, int numRepetitions, Consumer<ArrayList<Integer>> sortingMethod) {
        long averageTime = measureAverageTime(() -> {
            sortingMethod.accept(list);
        }, numRepetitions);

        return averageTime / 1000000000.0;
    }

}
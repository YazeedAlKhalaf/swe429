import Algorithms.InsertionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrUnsorted = new int[]{4,10,2};

        int[] insertionSorted = arrUnsorted.clone();
        int comparisons = InsertionSort.doSort(insertionSorted);
        printArray("insertionSorted", comparisons, insertionSorted);
    }

    static private void printArray(String arrayName, int comparisons, int[] arr) {
        System.out.println(arrayName + "(comparisons: "+comparisons + ")" + ": " + Arrays.toString(arr));
    }
}

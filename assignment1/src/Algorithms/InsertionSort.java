package Algorithms;

public class InsertionSort {
    public static int doSort(int[] arr) {
        int comparisons = 0;

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return comparisons;
    }
}

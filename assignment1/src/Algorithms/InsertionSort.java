package Algorithms;

public class InsertionSort implements SortingAlgorithm {
    public int doSort(int[] arr) {
        int comparisons = 0;

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }

        return comparisons;
    }
}

package Algorithms;

import java.util.*;

/*
Algorithm: Bubble Sort
Paradigm: Brute Force

Time Complexity: O(n^2)
Space Complexity: O(1)

Use Case:
Simple sorting algorithm, best for small or nearly sorted datasets.
Optimality: Not optimal for large datasets, mainly educational.
*/
public class BubbleSort {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to sort (space separated):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

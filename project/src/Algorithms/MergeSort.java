package Algorithms;

import java.util.*;

/*
Algorithm: Merge Sort
Paradigm: Divide and Conquer

Time Complexity: O(n log n) – each divide step splits the array in half (log n),
and each merge step processes all elements (n)
Space Complexity: O(n) – additional arrays are used for merging left and right halves

Use Case:
Efficient and stable sorting algorithm ideal for large datasets and linked lists.
Unlike quicksort, it guarantees O(n log n) time in all cases.
Used in external sorting where memory constraints apply (e.g., sorting files).

How It Works:
1. Recursively divide the array into two halves until subarrays have 1 element.
2. Merge sorted halves by comparing elements one by one.
3. Merged arrays are always sorted due to the recursive sorting of subarrays.

Properties:
- Stable: maintains relative order of equal elements
- Not in-place: requires extra space
- Deterministic: same input always results in same sequence of comparisons and swaps

Example:
Input: [5, 3, 8, 4, 2]
Output: [2, 3, 4, 5, 8]

Optimality: Among the best general-purpose sorting algorithms for large data.
*/
public class MergeSort {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers to sort (space separated):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            System.out.println("Dividing: " + Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
            System.out.println("After merging: " + Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        System.out.println("Merging left: " + Arrays.toString(L) + " and right: " + Arrays.toString(R));

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
package Algorithms;

public class MergeSort implements SortingAlgorithm {
    public int doSort(int[] arr) {
        int comparisons = 0;
        
        if (arr == null || arr.length <= 1) {
            return comparisons;
        }
        
        int[] temp = new int[arr.length];
        comparisons = mergeSort(arr, temp, 0, arr.length - 1);
        
        return comparisons;
    }
    
    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        int comparisons = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort left half
            comparisons += mergeSort(arr, temp, left, mid);
            
            // Sort right half
            comparisons += mergeSort(arr, temp, mid + 1, right);
            
            // Merge the sorted halves
            comparisons += merge(arr, temp, left, mid, right);
        }
        
        return comparisons;
    }
    
    private int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int comparisons = 0;
        
        // Copy both parts into the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;      // Index for left subarray
        int j = mid + 1;   // Index for right subarray
        int k = left;      // Index for merged array
        
        // Merge the two subarrays
        while (i <= mid && j <= right) {
            comparisons++; // Count comparison
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements from left subarray (if any)
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
        
        // Copy remaining elements from right subarray (if any)
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
        
        return comparisons;
    }
}

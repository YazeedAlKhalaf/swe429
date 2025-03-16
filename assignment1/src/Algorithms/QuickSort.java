package Algorithms;

public class QuickSort implements SortingAlgorithm {
    public int doSort(int[] arr) {
        int comparisons = 0;
        
        if (arr == null || arr.length <= 1) {
            return comparisons;
        }
        
        comparisons = quickSort(arr, 0, arr.length - 1);
        
        return comparisons;
    }
    
    private int quickSort(int[] arr, int low, int high) {
        int comparisons = 0;
        
        if (low < high) {
            // Partition the array and get the pivot position
            int[] result = partition(arr, low, high);
            int pivotIndex = result[0];
            comparisons += result[1];
            
            // Recursively sort the sub-arrays
            comparisons += quickSort(arr, low, pivotIndex - 1);  // Sort left of pivot
            comparisons += quickSort(arr, pivotIndex + 1, high); // Sort right of pivot
        }
        
        return comparisons;
    }
    
    private int[] partition(int[] arr, int low, int high) {
        int comparisons = 0;
        
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;
        
        // Traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            comparisons++; // Count comparison
            
            // If current element is smaller than the pivot
            if (arr[j] <= pivot) {
                i++;
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        // Return the pivot index and number of comparisons
        return new int[] {i + 1, comparisons};
    }
}

package Algorithms;

import java.util.*;

public class BinarySearch {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sorted numbers (space separated):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter target value:");
        int target = scanner.nextInt();

        int index = binarySearch(arr, target);

        if (index == -1) System.out.println("Not found.");
        else System.out.println("Found at index: " + index);
    }

    private int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

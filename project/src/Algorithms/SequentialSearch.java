package Algorithms;

import java.util.*;

/*
Algorithm: Sequential (Linear) Search
Paradigm: Brute Force

Time Complexity: O(n)
Space Complexity: O(1)

Use Case:
Searching an element in unsorted or small datasets.
Optimality: Simple but inefficient on large datasets.
*/
public class SequentialSearch {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (space separated):");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter target value:");
        int target = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        if (index == -1) System.out.println("Not found.");
        else System.out.println("Found at index: " + index);
    }
}

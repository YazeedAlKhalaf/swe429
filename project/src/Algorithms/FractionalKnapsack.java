package Algorithms;

import java.util.*;

/*
Algorithm: Fractional Knapsack
Paradigm: Greedy Algorithm

Time Complexity: O(n log n) – due to sorting by value-to-weight ratio
Space Complexity: O(n) – to store items and their ratios

Use Case:
When you can take fractions of items, e.g., filling a sack with grain.
Optimality: Optimal for fractional version – greedy strategy always works.
*/
public class FractionalKnapsack {
    static class Item {
        int value, weight;
        double ratio;
        Item(int v, int w) {
            value = v;
            weight = w;
            ratio = (double) v / w;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items:");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value and weight of item " + (i + 1) + ":");
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            items[i] = new Item(v, w);
        }

        System.out.println("Enter knapsack capacity:");
        int capacity = scanner.nextInt();

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0;
        System.out.println("Items taken (can be fractional):");
        for (Item item : items) {
            if (capacity >= item.weight) {
                System.out.println(" • Item (Weight: " + item.weight + ", Value: " + item.value + ") - 100%");
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                System.out.println(" • Item (Weight: " + item.weight + ", Value: " + item.value + ") - " + (100.0 * capacity / item.weight) + "%");
                totalValue += item.ratio * capacity;
                break;
            }
        }

        System.out.println("Maximum value in knapsack = " + totalValue);
    }
}
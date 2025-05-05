package Algorithms;

import java.util.*;

/*
Algorithm: 0/1 Knapsack
Paradigm: Dynamic Programming

Time Complexity: O(n × W), where n is number of items and W is capacity
Space Complexity: O(n × W) – can be optimized to O(W) with 1D DP

Use Case:
Packing indivisible items like laptops or tools into a bag.
Optimality: Guaranteed optimal via DP – greedy won't work here.
*/
public class Knapsack01 {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items:");
        int n = scanner.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value of item " + (i + 1) + ":");
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        System.out.println("Enter knapsack capacity:");
        int W = scanner.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + value[i - 1]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        System.out.println("Maximum value in knapsack = " + dp[n][W]);

        System.out.println("Items included (index starts at 1):");
        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println(" - Item " + i + " (Weight: " + weight[i - 1] + ", Value: " + value[i - 1] + ")");
                w -= weight[i - 1];
            }
        }
    }
}

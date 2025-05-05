package Algorithms;

import java.util.*;

/*
Algorithm: Longest Common Subsequence (LCS)
Paradigm: Dynamic Programming

Time Complexity: O(n × m), where n and m are lengths of the two strings
Space Complexity: O(n × m) – can be optimized to O(m)

Use Case:
Compare sequences where order matters but not necessarily adjacency.
Examples: File diffing, DNA sequence alignment, version control.
Optimality: Guaranteed optimal solution using DP.
*/
public class LCS {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string:");
        String s1 = scanner.nextLine();
        System.out.println("Enter second string:");
        String s2 = scanner.nextLine();

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println("Length of LCS = " + dp[n][m]);

        // Reconstruct LCS string
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS string: " + lcs.reverse().toString());
    }
}
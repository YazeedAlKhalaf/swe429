import Algorithms.*;

import java.util.Scanner;

class MenuApp {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Select an Algorithm Paradigm:");
            System.out.println("1. Brute Force");
            System.out.println("2. Divide and Conquer");
            System.out.println("3. Greedy Algorithms");
            System.out.println("4. Dynamic Programming");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bruteForceMenu();
                case 2 -> divideAndConquerMenu();
                case 3 -> greedyMenu();
                case 4 -> dynamicProgrammingMenu();
                case 5 -> System.exit(0);
            }
        }
    }

    private void bruteForceMenu() {
        System.out.println("Brute Force:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Sequential Search");
        int choice = scanner.nextInt();
        if (choice == 1) new BubbleSort().run();
        else if (choice == 2) new SequentialSearch().run();
    }

    private void divideAndConquerMenu() {
        System.out.println("Divide and Conquer:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Binary Search");
        int choice = scanner.nextInt();
        if (choice == 1) new MergeSort().run();
        else if (choice == 2) new BinarySearch().run();
    }

    private void greedyMenu() {
        System.out.println("Greedy Algorithms:");
        System.out.println("1. Job Scheduling");
        System.out.println("2. Fractional Knapsack");
        int choice = scanner.nextInt();
        if (choice == 1) new JobScheduling().run();
        else if (choice == 2) new FractionalKnapsack().run();
    }

    private void dynamicProgrammingMenu() {
        System.out.println("Dynamic Programming:");
        System.out.println("1. 0/1 Knapsack");
        System.out.println("2. Longest Common Subsequence");
        int choice = scanner.nextInt();
        if (choice == 1) new Knapsack01().run();
        else if (choice == 2) new LCS().run();
    }
}

package Algorithms;

import java.util.*;

/*
Algorithm: Job Scheduling with Deadlines and Profits
Paradigm: Greedy Algorithm

Time Complexity: O(n log n) – sorting by profit
Space Complexity: O(n) – for the slot array

Use Case:
Maximize profit from scheduling unit-time jobs with deadlines.
Examples: Task assignment with rewards and deadlines, CPU job queues.
Optimality: Greedy gives optimal solution for unit-time jobs.
*/
public class JobScheduling {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter deadline and profit for job " + (i + 1) + ":");
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(i + 1, deadline, profit);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        boolean[] slot = new boolean[maxDeadline + 1];
        Job[] scheduled = new Job[maxDeadline + 1];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    scheduled[j] = job;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Scheduled jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) {
                Job job = scheduled[i];
                System.out.println("Job " + job.id + " (Deadline: " + job.deadline + ", Profit: " + job.profit + ")");
            }
        }
        System.out.println("Total Profit: " + totalProfit);
    }
}

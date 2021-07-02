package com.coding_practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WeightedScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int profit = sc.nextInt();

            jobs[i] = new Job(start, end, profit);
        }

        JobComparator jobComparator = new JobComparator();
        Arrays.sort(jobs, jobComparator);

        System.out.println(maxProfit(jobs, n));

    }

    private static int maxProfit(Job[] jobs, int n) {

        int dp[] = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int incl = jobs[i].profit;
            int conflictingIndex = binarySearch(jobs, i);
            if (conflictingIndex != -1) {
                incl += dp[conflictingIndex];
            }
            dp[i] = Math.max(incl, dp[i - 1]);
        }
        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int i) {
        int low = 0;
        int high = i - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[i].start) {
                if (jobs[mid + 1].end <= jobs[i].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.end - o2.end;
    }
}

package com.learning.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long input[] = new long[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        long cost = 0;
        long target = 0;
        for (int i = 0; i < k; i++) {
            target += Math.abs(i * input[i] - cost);
            cost += input[i];
        }

        long min_diff = target;
        for (int i = k; i < n; i++) {
            cost = cost - input[i - k];
            target = target - Math.abs(cost - input[i - k] * (k - 1));
            target = target + Math.abs((cost - input[i] * (k - 1)));
            min_diff = Math.min(min_diff, target);
            cost += input[i];
        }

        System.out.println(min_diff);
    }
}

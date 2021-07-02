package com.coding_practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsoluteDifference {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(minAbsoluteDifference(input));
    }

    private static int minAbsoluteDifference(int[] input) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(input);
        for (int i = 1; i < input.length; i++) {
            int diff = input[i] - input[i - 1];
            min = (diff < min) ? diff : min;
        }
        return min;
    }
}

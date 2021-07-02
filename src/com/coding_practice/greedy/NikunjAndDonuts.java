package com.coding_practice.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NikunjAndDonuts {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] input = new Integer[n];
        for(int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input, Collections.reverseOrder());

        long res = 0;

        for(int i = 0; i < n; i++) {
            res += input[i] * Math.pow(2, i);
        }

        System.out.println(res);

    }
}

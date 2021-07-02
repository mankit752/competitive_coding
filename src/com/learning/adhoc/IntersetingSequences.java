package com.learning.adhoc;

import java.util.Scanner;

public class IntersetingSequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int minCost = Integer.MAX_VALUE;

        for(int i = min; i <= max; i++) {
            int dec = 0;
            int inc = 0;
            int cost;
            for(int j = 0; j < n; j++) {
                if(arr[j] > i) {
                    dec += arr[j] - i;
                }
                if(arr[j] < i){
                    inc += i - arr[j];
                }
            }
            if(dec > inc) {
                continue;
            } else {
                cost = dec*k + (inc-dec)*l;
                if(cost < minCost) {
                    minCost = cost;
                }
            }
        }
        System.out.println(minCost);

    }
}

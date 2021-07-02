package com.learning.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemDiscussion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long k = sc.nextLong();
        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long small = arr[0] + k;
        long big = arr[n - 1] - k;
        if (small > big)
            small = small ^ big ^ (big = small);
        //System.out.println(small + " " + big);

        for (int i = 1; i < n - 1; i++) {
            long sub = arr[i] - k;
            long add = arr[i] + k;

            if(sub >= small || add <= big) {
                continue;
            }
            if(big - sub <= add - small) {
                small = sub;
            } else {
                big = add;
            }
        }
        System.out.println(big - small);
        return;
    }
}

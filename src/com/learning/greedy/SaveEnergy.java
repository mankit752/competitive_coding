package com.learning.greedy;

import java.util.Scanner;

public class SaveEnergy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int curr = 0;
        long ans = 0;

        while (curr < (n - 1)) {
            int next = curr + 1;
            while (next < (n - 1)) {
                if ((Math.abs(arr[curr]) > Math.abs(arr[next])) || (Math.abs(arr[curr]) == Math.abs(arr[next]) && arr[curr] > 0)) {
                    break;
                } else {
                    next++;
                }
            }
            ans += (next - curr) * arr[curr] + (long)(((long)next * next - (long)curr *curr) * (arr[curr] * arr[curr]));
            curr = next;
        }
        System.out.println(ans);
        return;

    }
}

package com.learning.searching_and_sorting;

import java.util.Scanner;

public class TajMahalEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] res = new int[n];
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            arr[i] = sc.nextInt();
            t = (arr[i] - i) / n;

            if (arr[i] - i < 0) {
                t = 0;
            }
            else if ((arr[i] - i) % n != 0) {
                t += 1;
            }
            res[i] = t;

        }

        for (int i = 0; i < n; i++) {
            if (res[i] < min) {
                min = res[i];
                index = i;

            }
        }
        System.out.println((index + 1));

    }
}

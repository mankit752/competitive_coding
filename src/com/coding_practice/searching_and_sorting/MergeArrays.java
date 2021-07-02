package com.coding_practice.searching_and_sorting;

import java.util.Scanner;

public class MergeArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            for (int k = 0; i < N; i++) {
                arr1[k] = sc.nextInt();
                System.out.print(" arr1[k] = " + arr1[k]);
            }
            for (int j = 0; j < M; j++) {
                arr2[j] = sc.nextInt();
            }
            if(N < M) {
                System.out.println(merge(arr1, arr2, N, M));
            }
            else {
                System.out.println(merge(arr2, arr1, M, N));
            }
        }
    }
    public static double merge(int[] arr1, int[] arr2, int n, int m) {
        int begin1 = 0, end1 = n-1;

        while(begin1 < end1) {
            int i1 = (begin1 + end1)/2;
            int i2 = (n + m +1)/2 - i1;
            int min1 = (i1 == n) ? Integer.MAX_VALUE : arr1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : arr1[i1 - 1];
            int min2 = (i2 == m) ? Integer.MAX_VALUE : arr1[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : arr2[i2 - 1];

            if(max1 <= min2 && max2 <= min1) {
                if((n + m) % 2 == 0) {
                    return ((double)(Math.min(min1, min2) + Math.max(max1, max2))/2);
                }
                else{
                    return (double)Math.max(max1, max2);
                }
            }
            else if(max1 > min2){
                end1 = i1 - 1;
            }
            else {
                begin1 = i1 + 1;
            }
        }
    return -1;
    }

}

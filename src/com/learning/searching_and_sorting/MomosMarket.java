package com.learning.searching_and_sorting;

import java.util.Scanner;

public class MomosMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rates = new int[n];
        long[] leftSum = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            rates[i] = sc.nextInt();
            sum += rates[i];
            leftSum[i] = sum;
        }

        int q = sc.nextInt();


        while (q-- > 0) {
            int x = sc.nextInt();
            long rem = 0, num = 0;
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if(mid ==0 && leftSum[0] > x) {
                    num = 0;
                    rem = x;
                    break;
                }
                else if(leftSum[mid]/x == 0 || (leftSum[mid]/x == 1 && leftSum[mid]%x == 0)) {
                    rem = x-leftSum[mid];
                    num = mid +1;
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
            System.out.println(num + " " + (rem));
        }
    }

    /*private static boolean check(long[] leftSum, int n,int mid) {
        long res = 0;
        for(int i = 0; i < n; i++) {

        }
    }*/
}

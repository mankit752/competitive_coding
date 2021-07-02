package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class SortingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long l = 1;
        long r = n;
        long mid = 0;
        long midPrev = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (checkValue(n, mid)) {
                midPrev = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(midPrev);
    }

    private static boolean checkValue(long n, long mid) {
        long sum = 0;
        long curr = n;
        while (curr > 0) {
            sum += Math.min(curr, mid);
            curr -= mid;
            curr -= curr / 10;
        }
        if (2 * sum >= n) {
            return true;
        }
        return false;
    }
}

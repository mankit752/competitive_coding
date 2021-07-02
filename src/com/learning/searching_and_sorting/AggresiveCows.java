package com.learning.searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AggresiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int c = sc.nextInt();

            long[] pos = new long[n];

            for (int i = 0; i < n; i++) {
                pos[i] = sc.nextInt();
            }

            Arrays.sort(pos);
            long start = 0;
            long end = pos[n - 1] - pos[0];
            long ans = -1;

            while (start <= end) {
                long mid = start + (end - start) / 2;
                if (check(c, pos, n, mid)) {
                    ans = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
            System.out.println(ans);
        }
    }

    private static boolean check(int cows, long[] pos, int n, long mid) {
        long last_pos = pos[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (pos[i] - last_pos >= mid) {
                count++;
                last_pos = pos[i];
            }
            if (count == cows) {
                return true;
            }
        }
        return false;
    }
}

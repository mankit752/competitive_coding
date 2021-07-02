package com.learning.dynamic_programming;

import java.util.HashMap;
import java.util.Scanner;

public class DistinctSubsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int m = 1000000007;

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            HashMap<Character, Integer> map = new HashMap();
            long dp[] = new long[n + 1];

            dp[0] = 1;

            char ch;
            for (int i = 1; i < dp.length; i++) {
                ch = s.charAt(i - 1);
                dp[i] = 2 * dp[i - 1];
                if (map.containsKey(ch)) {
                    int l = map.get(ch);
                    dp[i] = (dp[i] % m - dp[l - 1] % m) % m;
                }
                map.put(ch, i);
            }
            System.out.println((dp[n] % m + m) % m);
        }
    }
}

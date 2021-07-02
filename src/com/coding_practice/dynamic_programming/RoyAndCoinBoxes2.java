package com.coding_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoyAndCoinBoxes2 {

    public static void main(String[] args) {

        FastReader s = new FastReader();
        int n = s.nextInt();

        int m = s.nextInt();

        int start[] = new int[n + 1];
        int end[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int l = s.nextInt();
            start[l]++;
            int r = s.nextInt();
            end[r]++;
        }

        int countInEachBox[] = new int[n + 1];
        countInEachBox[1] = start[1];
        for (int i = 2; i <= n; i++) {
            countInEachBox[i] = start[i] - end[i - 1] + countInEachBox[i - 1];
        }

        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[countInEachBox[i]]++;
        }

        int ans[] = new int[n + 1];
        ans[n] = dp[n];

        for (int i = n - 1; i >= 1; i--) {
            ans[i] = ans[i + 1] + dp[i];
        }


        int q = s.nextInt();

        for (int i = 1; i <= q; i++) {
            int t = s.nextInt();
            System.out.println(ans[t]);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

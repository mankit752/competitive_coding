package com.learning.segment_tree;

import java.util.Scanner;

public class HorribleQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            long tree[] = new long[4 * n];
            long lazy[] = new long[4 * n];
            for (int i = 1; i <= c; i++) {
                int op = sc.nextInt();
                if (op == 0) {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    long v = sc.nextInt();
                    update(tree, lazy, 0, n - 1, 1, p - 1, q - 1, v);
                } else if (op == 1) {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    System.out.println(query(tree, lazy, 0, n - 1, 1, p - 1, q - 1));
                }
            }
        }
    }

    private static long query(long[] tree, long[] lazy, int start, int end, int node, int left, int right) {
        //Completely outside
        if (start > end || start > right || end < left) {
            return 0;
        }

        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        long ans1 = query(tree, lazy, start, mid, 2 * node, left, right);
        long ans2 = query(tree, lazy, mid + 1, end, 2 * node + 1, left, right);
        return ans1 + ans2;

    }

    private static void update(long[] tree, long[] lazy, int start, int end, int node, int left, int right, long value) {

        //Pending update
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        //Completely outside
        if (start > end || start > right || end < left) {
            return;
        }

        //Complete overlap
        if (start >= left && end <= right) {
            tree[node] += (end - start + 1) * value;
            if (start != end) {
                lazy[2 * node] += value;
                lazy[2 * node + 1] += value;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        update(tree, lazy, start, mid, 2 * node, left, right, value);
        update(tree, lazy, mid + 1, end, 2 * node + 1, left, right, value);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
        return;
    }
}

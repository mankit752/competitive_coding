package com.learning.segment_tree;

import java.util.Scanner;

public class MinumumInSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int arr[] = new int[n];
        int tree[] = new int[4 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        buildTree(arr, tree, 0, n - 1, 1);

        for (int i = 1; i <= q; i++) {
            char op = sc.next().charAt(0);
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (op == 'q') {
                System.out.println(query(tree, 0, n - 1, 1, l - 1, r - 1));
            } else if (op == 'u') {
                updateTree(arr, tree, 0, n - 1, 1, l - 1, r);
            }
        }
    }

    private static void updateTree(int[] arr, int[] tree, int start, int end, int node, int index, int value) {
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        if (mid < index) {
            updateTree(arr, tree, mid + 1, end, 2 * node + 1, index, value);
        } else {
            updateTree(arr, tree, start, mid, 2 * node, index, value);
        }
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    private static void buildTree(int[] arr, int[] tree, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    private static int query(int[] tree, int start, int end, int node, int l, int r) {
        //Completely Oustide
        if (start > r || end < l) {
            return Integer.MAX_VALUE;
        }
        //Completely Inside
        if (start >= l && end <= r) {
            return tree[node];
        }
        //Partially
        int mid = start + (end - start) / 2;
        int ans1 = query(tree, start, mid, 2 * node, l, r);
        int ans2 = query(tree, mid + 1, end, 2 * node + 1, l, r);
        return Math.min(ans1, ans2);
    }


}

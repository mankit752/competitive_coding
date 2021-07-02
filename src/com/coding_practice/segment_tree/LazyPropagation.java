package com.coding_practice.segment_tree;

import java.util.Scanner;

public class LazyPropagation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int tree[] = new int[4 * n];
        int lazy[] = new int[4 * n];
        buildTree(arr, tree, 0, n - 1, 1);
        printTree(n, tree);

        updateSegmentTreeLazy(tree, lazy, 0, n - 1, 0, 3, 3, 1);
        updateSegmentTreeLazy(tree, lazy, 0, n - 1, 0, 1, 2, 1);

        System.out.println("Segment Tree");
        printTree(n, tree);
        System.out.println("Lazy Tree");
        printTree(n, lazy);

        System.out.println("Min = " + query(tree, lazy, 0, n - 1, 0, 2, 1));
    }

    private static void printTree(int n, int[] tree) {
        for (int i = 1; i < 2 * n; i++) {
            System.out.println(tree[i]);
        }
    }

    private static void buildTree(int[] arr, int[] tree, int start, int end, int node) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = getMid(start, end);
        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    private static void updateSegmentTreeLazy(int tree[], int lazy[], int start, int end, int low, int high, int incr, int currPos) {

        if (start > end) {
            return;
        }
        if (lazy[currPos] != 0) {
            tree[currPos] += lazy[currPos];

            if (start != end) {
                lazy[2 * currPos] += lazy[currPos];
                lazy[2 * currPos + 1] += lazy[currPos];
            }
            lazy[currPos] = 0;
        }

        //Completely Outside
        if (start > high || end < low) {
            return;
        }
        if (start >= low && end <= high) {
            tree[currPos] += incr;
            if (start != end) {
                lazy[2 * currPos] += incr;
                lazy[2 * currPos + 1] += incr;
            }
            return;
        }

        //Partially
        int mid = getMid(start, end);
        updateSegmentTreeLazy(tree, lazy, start, mid, low, high, incr, 2 * currPos);
        updateSegmentTreeLazy(tree, lazy, mid + 1, end, low, high, incr, 2 * currPos + 1);
        tree[currPos] = Math.min(tree[2 * currPos], tree[2 * currPos + 1]);

    }

    private static int query(int tree[], int lazy[], int start, int end, int left, int right, int currPos) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (lazy[currPos] != 0) {
            tree[currPos] += lazy[currPos];

            if (start != end) {
                lazy[2 * currPos] += lazy[currPos];
                lazy[2 * currPos + 1] += lazy[currPos];
            }
            lazy[currPos] = 0;
        }

        //Completely Outside
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }

        //Completely Inside
        if (start >= left && end <= right) {
            return tree[currPos];
        }
        //Partially
        int mid = getMid(start, end);
        query(tree, lazy, start, mid, left, right, 2 * currPos);
        query(tree, lazy, mid + 1, end, left, right, 2 * currPos + 1);
        return Math.min(tree[2 * currPos], tree[2 * currPos + 1]);
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}

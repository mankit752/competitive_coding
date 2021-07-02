package com.learning.segment_tree;

import java.util.Scanner;

public class BasicSegmentTreeOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        int tree[] = new int[2 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        buildTree(arr, tree, 0, n - 1, 1);
        print(tree, 2 * n);
        int index = sc.nextInt();
        int value = sc.nextInt();
        updateTree(arr, tree, 0, n - 1, 1, index, value);
        print(tree, 2 * n);

        System.out.println("Query Result = " + query(tree, 0, n-1, 1, 2, 4));
    }

    private static void updateTree(int[] arr, int[] tree, int start, int end, int node, int index, int value) {

        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (mid < index) {
            updateTree(arr, tree, mid + 1, end, 2 * node + 1, index, value);
        } else {
            updateTree(arr, tree, start, mid, 2 * node, index, value);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private static void buildTree(int[] arr, int[] tree, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private static int query(int[] tree, int start, int end, int node, int left, int right) {
        //Completely outside
        if(start > right || end < left) {
            return 0;
        }
        //Completely Inside
        if(start >= left && end <= right) {
            return tree[node];
        }
        //Partially Outside and inside
        int mid = start + (end - start)/2;
        int ans1 = query(tree, start, mid, 2*node, left, right);
        int ans2 = query(tree, mid + 1, end, 2*node + 1, left, right);
        return ans1 + ans2;
    }

    private static void print(int[] tree, int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(tree[i]);
        }
    }
}

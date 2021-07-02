package com.coding_practice.segment_tree;

import java.util.Scanner;

public class MaximumPairSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        Node tree[] = new Node[4 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildTree(arr, tree, 0, n - 1, 1);
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            char op = sc.next().charAt(0);
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (op == 'Q') {
                Node ans = query(tree, 0, n-1, 1, l - 1, r - 1);
                System.out.println(ans.max + ans.secondMax);
            } else {
                updateTree(arr, tree, 0, n - 1, 1, l - 1, r);
            }
        }
    }

    private static Node query(Node[] tree, int start, int end, int node, int left, int right) {
        Node temp = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        //Completely inside
        if(left <= start && right >= end) {
            return tree[node];
        }

        //Completely outside
        if(start > right || left > end) {
            return temp;
        }

        //Partially
        int mid = start + (end - start)/2;
        Node ans1 = query(tree, start, mid, 2 *node, left, right);
        Node ans2 = query(tree, mid + 1, end, 2 *node + 1, left, right);

        int max = Math.max(ans1.max, ans2.max);
        int sMax = Math.min(Math.max(ans1.max, ans2.secondMax), Math.max(ans1.secondMax, ans2.max));
        Node ans = new Node(max, sMax);
        return ans;

    }


    private static void updateTree(int[] arr, Node[] tree, int start, int end, int node, int index, int value) {

        if(start == end) {
            Node tree2 = new Node(value, Integer.MIN_VALUE);
            tree[node] = tree2;
            return;
        }

        else {
            int mid = start + (end - start) / 2;
            if (index > mid) {
                updateTree(arr, tree, mid + 1, end, 2 * node + 1, index, value);
            } else {
                updateTree(arr, tree, start, mid, 2 * node, index, value);
            }
            Node left = tree[2 * node];
            Node right = tree[2 * node + 1];

            tree[node].max = Math.max(left.max, right.max);
            tree[node].secondMax = Math.min(Math.max(left.max, right.secondMax), Math.max(left.secondMax, right.max));
            return;
        }
    }

    private static void buildTree(int[] arr, Node[] tree, int start, int end, int node) {

        if (start == end) {
            Node tree1 = new Node(arr[start], Integer.MIN_VALUE);
            tree[node] = tree1;
            return;
        }

        int mid = start + (end - start) / 2;
        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        Node left = tree[2 * node];
        Node right = tree[2 * node + 1];


        int ans1 = Math.max(left.max, right.max);
        int ans2 = Math.min(Math.max(left.max, right.secondMax), Math.max(left.secondMax, right.max));
        Node temp = new Node(ans1, ans2);
        tree[node] = temp;
    }

    private static void findMax(Node[] tree, int node) {
        if (tree[2 * node].max > tree[2 * node + 1].max) {
            Node tree2 = new Node(tree[2 * node].max, Math.max(tree[2 * node + 1].max, tree[2 * node].secondMax));
            tree[node] = tree2;
        } else {
            Node tree3 = new Node(tree[2 * node + 1].max, Math.max(tree[2 * node].max, tree[2 * node + 1].secondMax));
            tree[node] = tree3;
        }
    }
}

class Node {
    int max;
    int secondMax;

    public Node(int max, int secondMax) {
        this.max = max;
        this.secondMax = secondMax;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}

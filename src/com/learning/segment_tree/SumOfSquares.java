package com.learning.segment_tree;

import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            NodeSquares tree[] = new NodeSquares[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                tree[i] = new NodeSquares(0, 0);
            }
            NodeLazy lazy[] = new NodeLazy[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                lazy[i] = new NodeLazy(0, 0);
            }
            buildTree(arr, tree, lazy, 0, n - 1, 1);
            /*System.out.println("ST ");
            for(int i = 1; i < 2 * n; i++) {
                System.out.println(tree[i].sum + "   " + tree[i].squreSum);
            }

            System.out.println("LT ");
            for(int i = 1; i < 2 * n; i++) {
                System.out.println(lazy[i].value + "   " + lazy[i].type);
            }*/
            int type = sc.nextInt();
            if (type == 0) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                int val = sc.nextInt();
                updateSet(tree, lazy, 0, n - 1, left, right, val, 1);
            } else if (type == 1) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                int val = sc.nextInt();
                updateAdd(tree, lazy, 0, n - 1, left, right, val, 1);
            } else if (type == 2) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                query(tree, lazy, 0, n - 1, left, right, 1);
            }

        }
    }

    private static NodeSquares query(NodeSquares[] tree, NodeLazy[] lazy, int start, int end, int left, int right, int node) {
        return null;
    }


    private static void updateAdd(NodeSquares[] tree, NodeLazy[] lazy, int start, int end, int left, int right, int val, int node) {
    }

    private static void updateSet(NodeSquares[] tree, NodeLazy[] lazy, int start, int end, int left, int right, int val, int node) {
        if(start > end) {
            return;
        }
        if(lazy[node].value != 0 && lazy[node].type == 0) {
            long inc = lazy[node].value;
            tree[node].sum = inc + inc;
            tree[node].squreSum = (end - start + 1) * inc;
            if(start != end) {
                lazy[2 * node].value += inc;
                lazy[2 * node].type = 0;
                lazy[2 * node + 1].value += inc;
                lazy[2 * node + 1].type = 0;
            }
            lazy[node].value = 0;
            lazy[node].type = 0;
        }

        if(lazy[node].value != 0 && lazy[node].type == 1) {
            long inc = lazy[node].value;
            tree[node].sum = val * (end - start + 1);
            tree[node].squreSum = (end - start + 1) * (val * val) + (2 * val * inc);
            if(start != end) {
                lazy[2 * node].value += inc;
                lazy[2 * node].type = 1;
                lazy[2 * node + 1].value += inc;
                lazy[2 * node + 1].type = 1;
            }
            lazy[node].value = 1;
            lazy[node].type = 1;
        }

        /*if(start > )*/
    }

    private static void buildTree(int[] arr, NodeSquares[] tree, NodeLazy[] lazy, int start, int end, int node) {
        if (start == end) {
            long sum = arr[start];
            long sqSum = arr[start] * arr[start];
            tree[node] = new NodeSquares(sum, sqSum);
            return;
        }
        int mid = getMid(start, end);
        buildTree(arr, tree, lazy, start, mid, 2 * node);
        buildTree(arr, tree, lazy, mid + 1, end, 2 * node + 1);
        long sum = tree[2 * node].sum + tree[2 * node + 1].sum;
        long sqSum = tree[2 * node].squreSum + tree[2 * node + 1].squreSum;
        tree[node] = new NodeSquares(sum, sqSum);
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}

class NodeSquares {
    long sum;
    long squreSum;

    public NodeSquares(long sum, long squreSum) {
        this.sum = sum;
        this.squreSum = squreSum;
    }
}

class NodeLazy {
    long value;
    int type;

    public NodeLazy(long value, int type) {
        this.value = value;
        this.type = type;
    }
}
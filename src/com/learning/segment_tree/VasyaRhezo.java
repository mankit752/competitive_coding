package com.learning.segment_tree;

import java.util.Scanner;

public class VasyaRhezo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long A[] = new long[n];
        long B[] = new long[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextLong();
        }

        Warriors tree[] = new Warriors[4 * n];
        buildTree(A, B, tree, 0, n - 1, 1);
        //System.out.println("Tree");
        /*for (int i = 1; i < 2 * n; i++) {
            System.out.println(tree[i].toString());
        }*/
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            Warriors ans = query(tree, 0, n - 1, left - 1, right - 1, 1);
            System.out.println(ans.index + 1);
        }
    }

    private static Warriors query(Warriors[] tree, int start, int end, int left, int right, int node) {
        Warriors ans = new Warriors();
        ans.a = -1;
        ans.b = Integer.MAX_VALUE;
        ans.index = 10000002;

        if (start > right || end < left) {
            return ans;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = getMid(start, end);
        Warriors leftAns = query(tree, start, mid, left, right, 2 * node);
        Warriors rightAns = query(tree, mid + 1, end, left, right, 2 * node + 1);

        if (leftAns.a == rightAns.a && leftAns.b == rightAns.b) {
            if (leftAns.index < rightAns.index) {
                ans = leftAns;
            } else {
                ans = rightAns;
            }
        } else if (leftAns.a == rightAns.a) {
            if (leftAns.b < rightAns.b) {
                ans = leftAns;
            } else {
                ans = rightAns;
            }
        } else {
            if (leftAns.a > rightAns.a) {
                ans = leftAns;
            } else {
                ans = rightAns;
            }
        }
        return ans;

    }

    private static void buildTree(long[] a, long[] b, Warriors[] tree, int start, int end, int node) {

        if (start == end) {
            long aVal = a[start];
            long bVal = b[start];
            int indexVal = start;
            Warriors w = new Warriors(aVal, bVal, indexVal);
            tree[node] = w;
            return;
        }
        int mid = getMid(start, end);
        buildTree(a, b, tree, start, mid, 2 * node);
        buildTree(a, b, tree, mid + 1, end, 2 * node + 1);
        if (tree[2 * node].a == tree[2 * node + 1].a && tree[2 * node].b == tree[2 * node + 1].b) {
            if (tree[2 * node].index < tree[2 * node + 1].index) {
                tree[node] = tree[2 * node];
            } else {
                tree[node] = tree[2 * node + 1];
            }
        } else if (tree[2 * node].a == tree[2 * node + 1].a) {
            if (tree[2 * node].b < tree[2 * node + 1].b) {
                tree[node] = tree[2 * node];
            } else {
                tree[node] = tree[2 * node + 1];
            }
        } else {
            if (tree[2 * node].a > tree[2 * node + 1].a) {
                tree[node] = tree[2 * node];
            } else {
                tree[node] = tree[2 * node + 1];
            }
        }
        return;
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}

class Warriors {
    long a;
    long b;
    int index;

    public Warriors() {
    }

    public Warriors(long a, long b, int index) {
        this.a = a;
        this.b = b;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Warriors{" +
                "a=" + a +
                ", b=" + b +
                ", index=" + index +
                '}';
    }
}
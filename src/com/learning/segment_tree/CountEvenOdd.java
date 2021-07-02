package com.learning.segment_tree;

import java.util.Scanner;

public class CountEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        EvenOdd tree[] = new EvenOdd[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new EvenOdd(0, 0);
        }
        buildTree(arr, tree, 0, n - 1, 1);
        //print(n, tree);
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (op == 0) {
                update(arr, tree, 0, n - 1, x - 1, y, 1);
                //print(n, tree);
            } else {
                EvenOdd ans = query(tree, 0, n - 1, x - 1, y - 1, 1);
                if (op == 1) {
                    System.out.println(ans.countEven);
                } else if (op == 2) {
                    System.out.println(ans.countOdd);
                }
                //System.out.println(ans.countEven + "   " + ans.countOdd);
            }
        }

    }

    private static EvenOdd query(EvenOdd[] tree, int start, int end, int left, int right, int node) {

        //Completely outside
        if (start > right || end < left) {
            return new EvenOdd(0, 0);
        }
        //Completely inside
        if (start >= left && end <= right) {
            return tree[node];
        }
        //Partially
        int mid = getMid(start, end);
        if (left > mid)
            query(tree, start, mid, left, right, 2 * node);
        if (right <= mid)
            query(tree, mid + 1, end, left, right, 2 * node + 1);

        EvenOdd leftAns = query(tree, start, mid, left, right, 2 * node);
        EvenOdd rightAns = query(tree, mid + 1, end, left, right, 2 * node + 1);

        int even = leftAns.countEven + rightAns.countEven;
        int odd = leftAns.countOdd + rightAns.countOdd;

        return new EvenOdd(even, odd);
    }

    private static void print(int n, EvenOdd[] tree) {
        System.out.println("Tree");
        for (int i = 1; i < 2 * n; i++) {
            System.out.println(tree[i].countEven + "   " + tree[i].countOdd);
        }
    }

    private static void buildTree(int[] arr, EvenOdd[] tree, int start, int end, int node) {
        if (start == end) {
            if (arr[start] % 2 == 0) {
                tree[node].countEven++;
            } else {
                tree[node].countOdd++;
            }
            return;
        }
        int mid = getMid(start, end);
        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        tree[node].countEven = tree[2 * node].countEven + tree[2 * node + 1].countEven;
        tree[node].countOdd = tree[2 * node].countOdd + tree[2 * node + 1].countOdd;
        return;

    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    private static void update(int[] arr, EvenOdd[] tree, int start, int end, int index, int y, int node) {
        if (start == end) {
            arr[index] = y;
            if (y % 2 == 0) {
                tree[node].countEven = 1;
                tree[node].countOdd = 0;
            } else {
                tree[node].countOdd = 1;
                tree[node].countEven = 0;
            }
            return;
        }
        int mid = getMid(start, end);
        if (index > mid) {
            update(arr, tree, mid + 1, end, index, y, 2 * node + 1);
        } else {
            update(arr, tree, start, mid, index, y, 2 * node);
        }

        tree[node].countEven = tree[2 * node].countEven + tree[2 * node + 1].countEven;
        tree[node].countOdd = tree[2 * node].countOdd + tree[2 * node + 1].countOdd;
        return;
    }

}

class EvenOdd {
    int countEven;
    int countOdd;

    public EvenOdd(int countEven, int countOdd) {
        this.countEven = countEven;
        this.countOdd = countOdd;
    }
}
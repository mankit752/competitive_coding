package com.learning.segment_tree;

import java.util.Scanner;

public class MaximumSumInSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        NodeSum tree[] = new NodeSum[4 * n];

        buildTree(arr, tree, 0, n - 1, 1);
        //printTree(n, tree);
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            NodeSum ans = query(tree, 0, n - 1, 1, x - 1, y - 1);
            System.out.println(ans.maxSum);
        }

    }

    private static NodeSum query(NodeSum[] tree, int start, int end, int node, int x, int y) {
        //completely inside
        if (start >= x && end <= y) {
            return tree[node];
        }

        //completely outside
        if (start > y || end < x) {
            int sum = -60000;
            int maxSum = -60000;
            int bps = -60000;
            int bss = -60000;

            NodeSum temp = new NodeSum(sum, maxSum, bps, bss);
            return temp;
        }

        //Partially
        int mid = getMid(start, end);
        NodeSum left = query(tree, start, mid, 2 * node, x, y);
        NodeSum right = query(tree, mid + 1, end, 2 * node + 1, x, y);

        int sum = left.sum + right.sum;
        int maxSum = Math.max(left.maxSum, Math.max(right.maxSum, Math.max(right.bestPrefixSum,
                Math.max(left.bestSuffixSum, left.bestSuffixSum + right.bestPrefixSum))));
        int bps = Math.max(left.bestPrefixSum, left.sum + right.bestPrefixSum);
        int bss = Math.max(right.bestSuffixSum, right.sum + left.bestSuffixSum);

        NodeSum ans = new NodeSum(sum, maxSum, bps, bss);
        return ans;
    }

    private static void printTree(int n, NodeSum[] tree) {
        for (int i = 1; i < 2 * n; i++) {
            System.out.println(tree[i].sum + "  " + tree[i].maxSum + "  " + tree[i].bestPrefixSum + "  " + tree[i].bestSuffixSum);
        }
    }

    private static void buildTree(int[] arr, NodeSum[] tree, int start, int end, int node) {

        if (start == end) {
            int sum = arr[start];
            int maxSum = arr[start];
            int bps = arr[start];
            int bss = arr[start];

            NodeSum temp = new NodeSum(sum, maxSum, bps, bss);
            tree[node] = temp;
            return;
        }

        int mid = getMid(start, end);
        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);

        fillTree(tree, node);
        return;
    }

    private static void fillTree(NodeSum[] tree, int node) {
        NodeSum left = tree[2 * node];
        NodeSum right = tree[2 * node + 1];

        int sum = left.sum + right.sum;
        int maxSum = Math.max(left.maxSum, Math.max(right.maxSum, Math.max(right.bestPrefixSum,
                Math.max(left.bestSuffixSum, left.bestSuffixSum + right.bestPrefixSum))));
        int bps = Math.max(left.bestPrefixSum, left.sum + right.bestPrefixSum);
        int bss = Math.max(right.bestSuffixSum, right.sum + left.bestSuffixSum);

        NodeSum temp = new NodeSum(sum, maxSum, bps, bss);
        tree[node] = temp;
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}

class NodeSum {
    int sum, maxSum, bestPrefixSum, bestSuffixSum;

    public NodeSum(int sum, int maxSum, int bestPrefixSum, int bestSuffixSum) {
        this.sum = sum;
        this.maxSum = maxSum;
        this.bestPrefixSum = bestPrefixSum;
        this.bestSuffixSum = bestSuffixSum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(int maxSum) {
        this.maxSum = maxSum;
    }

    public int getBestPrefixSum() {
        return bestPrefixSum;
    }

    public void setBestPrefixSum(int bestPrefixSum) {
        this.bestPrefixSum = bestPrefixSum;
    }

    public int getBestSuffixSum() {
        return bestSuffixSum;
    }

    public void setBestSuffixSum(int bestSuffixSum) {
        this.bestSuffixSum = bestSuffixSum;
    }
}
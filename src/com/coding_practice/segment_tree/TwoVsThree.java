package com.coding_practice.segment_tree;

import java.util.Scanner;

public class TwoVsThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String st = sc.next();

        NodeTwoThree tree[] = new NodeTwoThree[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new NodeTwoThree(0, 0);
        }
        buildTree(st, tree, 0, n - 1, 1);
        /*for (int i = 0; i < 4 * n; i++) {
            System.out.println(tree[i].toString());
        }*/
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int op = sc.nextInt();
            if (op == 0) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                NodeTwoThree ans = query(tree, 0, n - 1, 1, left, right);
                System.out.println(ans.val);
            } else if (op == 1) {
                int index = sc.nextInt();
                update(tree, 0, n - 1, 1, index);
            }
        }
    }

    private static void update(NodeTwoThree[] tree, int start, int end, int node, int index) {

        if(start == end) {
            tree[node].val = 1;
            tree[node].val = 1;
            return;
        }

        int mid = getMid(start, end);
        if (index <= mid) {
            update(tree, start, mid, 2 * node, index);
        } else {
            update(tree, mid + 1, end, 2 * node + 1, index);
        }
        tree[node].val = (tree[2 * node + 1].val + (tree[2 * node].val) * (int) Math.pow(2, (tree[2 * node + 1].len) % 2)) % 3;
        tree[node].len = tree[2 * node + 1].len + tree[2 * node].len;
        return;
    }

    private static NodeTwoThree query(NodeTwoThree[] tree, int start, int end, int node, int left, int right) {
        NodeTwoThree ans = new NodeTwoThree(0, 0);
        if (start > right || end < left) {
            return ans;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = getMid(start, end);
        NodeTwoThree ans1 = query(tree, start, mid, 2 * node, left, right);
        NodeTwoThree ans2 = query(tree, mid + 1, end, 2 * node + 1, left, right);

        ans.val = (ans2.val + ans1.val*(int)Math.pow(2,(ans2.len)%2))%3;
        ans.len = ans1.len + ans2.len;
        return ans;
    }

    private static void buildTree(String st, NodeTwoThree[] tree, int start, int end, int node) {

        if (start == end) {
            int val = st.charAt(start) - '0';
            tree[node] = new NodeTwoThree(val, 1);
            /*tree[node].val = st.charAt(start) -  '0';
            tree[node].len = 1;*/
            return;
        }

        int mid = getMid(start, end);
        buildTree(st, tree, start, mid, 2 * node);
        buildTree(st, tree, mid + 1, end, 2 * node + 1);
        tree[node].val = (tree[2 * node + 1].val + (tree[2 * node].val) * (int) (Math.pow(2, (tree[2 * node + 1].len) % 2))) % 3;
        tree[node].len = (tree[2 * node + 1].len + tree[2 * node].len);
        return;
    }

    private static int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
}

class NodeTwoThree {
    int val;
    int len;

    public NodeTwoThree() {
    }

    public NodeTwoThree(int val, int len) {
        this.val = val;
        this.len = len;
    }

    @Override
    public String toString() {
        return "NodeTwoThree{" +
                "val=" + val +
                ", len=" + len +
                '}';
    }
}
package com.coding_practice.graphs;

import java.util.Scanner;

public class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        boolean adj[][] = new boolean[n][n];
        boolean visited[] = new boolean[n];

        for(int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adj[start][end] = true;
            adj[end][start] = true;
        }

        print(adj, n, 0, visited);

    }

    private static void print(boolean[][] adj, int n, int start, boolean[] visited) {
        System.out.println(start);
        visited[start] = true;

        for(int i = 0; i < n; i++) {
            if(i == start) {
                continue;
            }
            if(adj[start][i] == true) {
                if (visited[i]) {
                    continue;
                }
                print(adj, n, i, visited);
            }
        }
    }


}

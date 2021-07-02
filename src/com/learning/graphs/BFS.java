package com.learning.graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        if(n == 0 && e == 0) {
            return;
        }
        if(n == 0) {
            return;
        }
        if(n != 0 && e == 0) {
            for(int i = 0; i < n; i++)
                System.out.print(i + " ");
            return;
        }

        boolean adj[][] = new boolean[n][n];

        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            adj[start][end] = true;
            adj[end][start] = true;
        }

        printHelp(adj, n, 0);
    }

    //For disconnected graph
    private static void printHelp(boolean[][] adj, int n, int sv) {
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                printBFS(adj, n, i, visited);
            }
        }
    }

    private static void printBFS(boolean[][] adj, int n, int sv, boolean[] visited) {

        Queue<Integer> pendingVertices = new LinkedList<>();
        ((LinkedList<Integer>) pendingVertices).addLast(sv);

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();
            System.out.print(currentVertex + " ");
            visited[sv] = true;
            for (int i = 0; i < n; i++) {
                if (i == currentVertex) {
                    continue;
                }
                if (adj[currentVertex][i] == true && visited[i] == false) {
                    ((LinkedList<Integer>) pendingVertices).add(i);
                    visited[i] = true;
                }
            }

        }
    }
}

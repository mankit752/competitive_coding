package com.learning.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Islands {

    public static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");
        int v = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int edges[][] = new int[v][v];
        for (int i = 0; i < e; i++) {
            String[] strInput = br.readLine().split("\\s");
            int a = Integer.parseInt(strInput[0]);
            int b = Integer.parseInt(strInput[1]);
            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        System.out.println(printCountConnectedComponents(edges, v));
    }

    private static int printCountConnectedComponents(int[][] edges, int n) {
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                printHelper(edges, n, visited, i);
            }
        }
        return count;
    }

    private static void printHelper(int[][] edges, int n, boolean[] visited, int sv) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        ((LinkedList<Integer>) pendingVertices).add(sv);
        visited[sv] = true;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();

            for (int i = 0; i < n; i++) {
                if (i == sv) {
                    continue;
                }
                if (edges[currentVertex][i] == 1 && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}


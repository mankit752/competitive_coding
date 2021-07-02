package com.learning.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AllConnectedComponents {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");
        int v = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        boolean edges[][] = new boolean[v][v];
        for (int i = 0; i < e; i++) {
            String[] strInput = br.readLine().split("\\s");
            int a = Integer.parseInt(strInput[0]);
            int b = Integer.parseInt(strInput[1]);
            edges[a][b] = true;
            edges[b][a] = true;
        }

        printConnectedComponents(edges, v);
    }

    private static void printConnectedComponents(boolean[][] edges, int n) {
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                printHelper(edges, n, visited, i);
            System.out.println();
        }
    }

    private static void printHelper(boolean[][] edges, int n, boolean[] visited, int sv) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        ((LinkedList<Integer>) pendingVertices).add(sv);
        visited[sv] = true;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(sv);

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();

            for (int i = 0; i < n; i++) {
                if (i == sv) {
                    continue;
                }
                if (edges[currentVertex][i] && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                    res.add(i);
                }
            }
        }
        Collections.sort(res);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}

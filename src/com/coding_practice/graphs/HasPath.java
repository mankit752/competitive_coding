package com.coding_practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");
        int v = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        boolean edges[][] = new boolean[v][v];
        for(int i = 0; i < e; i++) {
            String[] strInput = br.readLine().split("\\s");
            int a = Integer.parseInt(strInput[0]);
            int b = Integer.parseInt(strInput[1]);
            edges[a][b] = true;
            edges[b][a] = true;
        }
        String[] strPath = br.readLine().split("\\s");
        int start = Integer.parseInt(strPath[0]);
        int end = Integer.parseInt(strPath[1]);

        System.out.println(checkPath(edges, v, start, end));
    }

    private static boolean checkPath(boolean[][] edges, int v, int start, int end) {
        boolean visited[] = new boolean[v];
        Queue<Integer> pendingVertices = new LinkedList<>();
        ((LinkedList<Integer>) pendingVertices).add(start);
        visited[start] = true;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();

            for(int i = 0; i < v; i++) {
                if(i == start) {
                    continue;
                }  if(edges[currentVertex][i] && !visited[i]) {
                    if(i == end) {
                        return true;
                    }
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}

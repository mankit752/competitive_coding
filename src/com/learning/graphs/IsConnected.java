package com.learning.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class IsConnected {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split("\\s");
        int v = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        if(v == 0 && e == 0) {
            System.out.println("true");
            return;
        }

        boolean edges[][] = new boolean[v][v];
        for (int i = 0; i < e; i++) {
            String[] strInput = br.readLine().split("\\s");
            int a = Integer.parseInt(strInput[0]);
            int b = Integer.parseInt(strInput[1]);
            edges[a][b] = true;
            edges[b][a] = true;
        }

        System.out.println(checkIsConnected(edges, v, 0));
    }

    private static boolean checkIsConnected(boolean[][] edges, int v, int sv) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[v];

        ((LinkedList<Integer>) pendingVertices).add(sv);
        visited[sv] = true;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();

            for(int i = 0; i < v; i++) {
                if(i == sv)
                    continue;
                if(edges[currentVertex][i] && !visited[i]) {
                    visited[i] = true;
                    pendingVertices.add(i);
                }
            }
        }
        for (Boolean value: visited) {
            if(value == false) {
                return false;
            }
        }
        return true;
    }
}

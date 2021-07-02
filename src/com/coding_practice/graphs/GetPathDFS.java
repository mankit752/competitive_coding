package com.coding_practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetPathDFS {

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

        String[] strPath = br.readLine().split("\\s");
        int start = Integer.parseInt(strPath[0]);
        int end = Integer.parseInt(strPath[1]);

        boolean visited[] = new boolean[v];

        ArrayList<Integer> res = getDFSPath(edges, v, start, end, visited);
        for (Integer i: res) {
            System.out.print(i + " ");
        }

    }

    private static ArrayList<Integer> getDFSPath(boolean[][] edges, int v, int start, int end, boolean[] visited) {
        ArrayList<Integer> res = new ArrayList<>();
        if (start == end) {
            res.add(start);
            return res;
        }
        visited[start] = true;

        for (int i = 0; i < v; i++) {
            boolean val = false;
            if (start == i) {
                continue;
            }
            if (edges[start][i] && !visited[i]) {
                res = getDFSPath(edges, v, i, end, visited);
                if (!res.isEmpty()) {
                    res.add(start);
                    return res;
                }
            }
        }
        return res;
    }

}

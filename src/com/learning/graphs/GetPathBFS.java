package com.learning.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GetPathBFS {

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

        ArrayList<Integer> result = getBFSPath(edges, v, start, end);
        if(result != null) {
            for (Integer i: result) {
                System.out.print(i + " ");
            }
        }
    }

    private static ArrayList<Integer> getBFSPath(boolean[][] edges, int v, int start, int end) {

        boolean visited[] = new boolean[v + 1];
        Queue<Integer> pendingVertices = new LinkedList<>();
        Map<Integer, Integer> previousMap = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        ((LinkedList<Integer>) pendingVertices).add(start);
        visited[start] = true;
        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.remove();

            for(int i = 0; i < v; i++) {
                if(i == start) {
                    continue;
                }
                if(edges[currentVertex][i] && !visited[i]) {
                    pendingVertices.add(i);
                    previousMap.put(i, currentVertex);
                    visited[i] = true;
                    if(i == end) {
                        break;
                    }
                }
            }
        }
        if(visited[end]) {
            int temp = end;
            while (temp != start) {
                result.add(temp);
                temp = previousMap.get(temp);
            }
            result.add(start);
        }
        return result;
    }
}

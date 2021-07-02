package com.coding_practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());


        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = dfs(edge, edge.length);
        System.out.println(ans);
    }

    private static int dfs(String[] edge, int length) {
        int max = 0;
        boolean visited[][] = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (edge[i].charAt(j) == '1' && visited[i][j] == false) {
                    int[] k = new int[1];
                    helper(edge, i, j, k, visited, length);
                    max = Math.max(max, k[0]);
                }
            }
        }
        return max;
    }

    private static void helper(String[] edge, int i, int j, int []k, boolean[][] visited, int n) {
        k[0]++;
        visited[i][j] = true;

        if ((i + 1) < n && edge[i + 1].charAt(j) == '1' && visited[i + 1][j] == false)
            helper(edge, i + 1, j, k, visited, n);

        if ((i - 1) >= 0 && edge[i - 1].charAt(j) == '1' && visited[i - 1][j] == false)
            helper(edge, i - 1, j, k, visited, n);

        if ((j + 1) < n && edge[i].charAt(j + 1) == '1' && visited[i][j + 1] == false)
            helper(edge, i, j + 1, k, visited, n);

        if ((j - 1) >= 0 && edge[i].charAt(j - 1) == '1' && visited[i][j - 1] == false)
            helper(edge, i, j - 1, k, visited, n);

    }
}

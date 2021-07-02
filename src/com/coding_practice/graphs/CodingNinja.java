package com.coding_practice.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingNinja {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }


        String[] graph = new String[input[0]];

        for (int i = 0; i < input[0]; ++i) {
            graph[i] = br.readLine();
        }

        return graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] graph = takeInput();
        System.out.println(solve(graph, graph.length, graph[0].length()));


    }

    private static int solve(String[] graph, int n, int m) {
        final String s = "CODINGNINJA";
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                boolean ans = false;
                if (graph[i].charAt(j) == 'C') {
                    ans = dfs(graph, s, c + 1, i, j, n, m, visited);
                    if (ans) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean dfs(String[] graph, String s, int c, int i, int j, int n, int m, boolean[][] visited) {
        if (graph[i].charAt(j) == 'A') {
            return true;
        }
        visited[i][j] = true;
        boolean ans = false;

        if ((i - 1) >= 0 && (j - 1) >= 0 && graph[i - 1].charAt(j - 1) == s.charAt(c) && !visited[i - 1][j - 1]) {
            ans = ans || dfs(graph, s, c + 1, i - 1, j - 1, n, m, visited);
        }
        if (i - 1 >= 0 && graph[i - 1].charAt(j) == s.charAt(c) && !visited[i - 1][j])
            ans = ans || dfs(graph, s, c + 1, i - 1, j, n, m, visited);

        if (i - 1 >= 0 && j + 1 < m && graph[i - 1].charAt(j + 1) == s.charAt(c) && !visited[i - 1][j + 1])
            ans = ans || dfs(graph, s, c + 1, i - 1, j + 1, n, m, visited);

        if (j + 1 < m && graph[i].charAt(j + 1) == s.charAt(c) && !visited[i][j + 1])
            ans = ans || dfs(graph, s, c + 1, i, j + 1, n, m, visited);

        if (i + 1 < n && j + 1 < m && graph[i + 1].charAt(j + 1) == s.charAt(c) && !visited[i + 1][j + 1])
            ans = ans || dfs(graph, s, c + 1, i + 1, j + 1, n, m, visited);

        if (i + 1 < n && graph[i + 1].charAt(j) == s.charAt(c) && !visited[i + 1][j])
            ans = ans || dfs(graph, s, c + 1, i + 1, j, n, m, visited);

        if (i + 1 < n && j - 1 >= 0 && graph[i + 1].charAt(j - 1) == s.charAt(c) && !visited[i + 1][j - 1])
            ans = ans || dfs(graph, s, c + 1, i + 1, j - 1, n, m, visited);

        if (j - 1 >= 0 && graph[i].charAt(j - 1) == s.charAt(c) && !visited[i][j - 1])
            ans = ans || dfs(graph, s, c + 1, i, j - 1, n, m, visited);

        visited[i][j] = false;
        return ans;
    }
}

package com.coding_practice.graphs;

import java.util.Scanner;

public class Prims {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[v][v];

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[src][dest] = weight;
            edges[dest][src] = weight;
        }

        prims(edges, v);


    }

    private static void prims(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] weight = new int[n];

        for(int i = 0; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;

        for(int i = 0; i < n-1; i++) {

            //get unvisited vertex with minimum weight
            int minVertex = getMinVertex(visited, weight, n);
            visited[minVertex] = true;

            //Explore all the neighbours of min vertex and update parent and weight array

            for(int j = 0; j < n; j++) {
                if(edges[minVertex][j] != 0 && !visited[j]) {
                    if(weight[j] > edges[minVertex][j]) {
                        weight[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++) {
            if(parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            } else {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }

    private static int getMinVertex(boolean[] visited, int[] weight, int n) {
        int minVertex = -1;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && (minVertex == -1 || weight[minVertex] > weight[i])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static void print(int e, Edge[] edges) {
        for (int i = 0; i < e; i++) {
            System.out.println(edges[i].toString());
        }
    }
}

package com.coding_practice.graphs;

import java.util.Scanner;

public class Dijkstras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[V][E];
        for (int i = 0; i < V; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();
            edges[f][s] = w;
            edges[s][f] = w;
        }


        dijkstras(edges, V);
    }

    private static void dijkstras(int[][] edges, int v) {
        boolean[] visited = new boolean[v];
        int[] dist = new int[v];
        for (int i = 1; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < v - 1; i++) {
            //Get unvisited Vertex with Minimum weight
            int minVertex = getMinVertex(dist, visited, v);
            visited[minVertex] = true;
            //Explore all neighbours of MinVertex which are unvisited and updated the a=dist array if required
            for (int j = 0; j < v; j++) {
                if (edges[minVertex][j] != 0 && !visited[j]) {
                    int currentDistance = dist[minVertex] + edges[minVertex][j];
                    if (dist[j] > currentDistance) {
                        dist[j] = currentDistance;
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + dist[i]);
        }


    }

    private static int getMinVertex(int[] dist, boolean[] visited, int v) {
        int minVertex = -1;
        for (int i = 0; i < v; i++) {
            if (!visited[i] && (minVertex == -1 || dist[i] < dist[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}

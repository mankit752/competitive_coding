package com.learning.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            Edge temp = new Edge(src, dest, weight);
            edges[i] = temp;
        }

        Arrays.sort(edges, Comparator.comparingInt(Edge::getWeight));

        Edge[] result = kruskals(edges, v, e);

        print(v - 1, result);
    }

    private static Edge[] kruskals(Edge[] edges, int v, int e) {
        int parent[] = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        Edge[] result = new Edge[v - 1];

        int count = 0, i = 0;
        while (count < v - 1) {
            //check topmost Parent of v1 and v2 where v1 and v2 are source and dest of current edge
            Edge currentEdge = edges[i];
            int srcParent = getParent(parent, currentEdge.getSource());
            int destParent = getParent(parent, currentEdge.getDest());

            if (srcParent != destParent) {
                result[count] = currentEdge;
                count++;
                parent[srcParent] = destParent;
            }
            i++;
        }
        return result;
    }

    private static int getParent(int[] parent, int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return getParent(parent, parent[vertex]);

    }

    private static void print(int e, Edge[] edges) {
        for (int i = 0; i < e; i++) {
            System.out.println(edges[i].toString());
        }
    }
}

class Edge {
    private int source;
    private int dest;
    private int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        if(source < dest) {
            return source + " " + dest + " " + weight;
        }
        else {
            return dest + " " + source + " " + weight;
        }
    }
}

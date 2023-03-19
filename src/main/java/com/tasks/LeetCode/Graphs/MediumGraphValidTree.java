package com.tasks.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MediumGraphValidTree {

    // You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where
    // edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
    // Return true if the edges of the given graph make up a valid tree, and false otherwise.

    // 1) Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
    // 2) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any
    // two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a
    // tree.”

    // My thoughts
    // 1) How can we use n to check our undirected edges? What for we need n?
    // 2) In edges[][] we can check our vertices

    // Valid tree it's a distinct of vertices
    public static void main(String[] args) {
        int n = 5;

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}}; //Output: true

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}; //Output: false

        int[][] edges2 = {{0, 1}, {1, 2}, {3, 4}}; //Output: true

        System.out.println(validTree(n, edges));
        System.out.println(validTree(n, edges1));
        System.out.println(validTree(n, edges2));
    }

    // Approach 1: Graph Theory + Iterative Depth-First Search


    private static boolean validTree(int n, int[][] edges) {
        // Create a new list of lists.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // Initialize an empty list for each node.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // Go through the edge list, populating the adjacency list
        for (int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return false;
    }
}

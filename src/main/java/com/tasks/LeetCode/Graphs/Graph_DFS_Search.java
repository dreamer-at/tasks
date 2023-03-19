package com.tasks.LeetCode.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_DFS_Search {

    public static void main(String[] args) {
        Graph_DFS_Search g = new Graph_DFS_Search(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,3);

        System.out.println("Following is Depth First Traversal");
        g.DFS_SearchFunction(2);
    }

    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    Graph_DFS_Search(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // For valid tree we should not have duplicate vertex
    void DFS_SearchFunction(int vertex) {
        visited[vertex] = true;
        System.out.println("visited vertex is " + vertex);

        Iterator ite = adjLists[vertex].listIterator();

        while (ite.hasNext()) {
            int adj = (int) ite.next();
            if (!visited[adj]) {
                DFS_SearchFunction(adj);
            }
        }
    }

    void addEdge(int parent, int child) {
        adjLists[parent].add(child);
    }
}

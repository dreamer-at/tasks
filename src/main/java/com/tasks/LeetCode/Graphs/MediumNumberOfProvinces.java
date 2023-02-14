package com.tasks.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MediumNumberOfProvinces {

    // There are n cities. Some of them are connected, while some are not. If city a is connected directly with city
    // b, and city b is connected directly with city c, then city a is connected indirectly with city c.
    // A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    // You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
    // directly connected, and isConnected[i][j] = 0 otherwise.
    // Return the total number of provinces.

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        System.out.println(findCircleNumDFS(isConnected));
        System.out.println(findCircleNumDFS(isConnected1));

    }

    // Approach #1 Using Depth First Search[Accepted]
    // From the graph, we can see that the components which are connected can be reached starting from any single
    // node of the connected group. Thus, to find the number of connected components, we start from every node which
    // isn't visited right now and apply DFS starting with it. We increment the "count" of connected
    // components for every new starting node.

    // Complexity Analysis
    // Time complexity : O(n2). The complete matrix of size n^2 is traversed.
    // Space complexity : O(n). visited array of size n is used.
    private static int findCircleNumDFS(int[][] isConnected) {
        // visited vertexes, store all visited vertexes
        int[] visited = new int[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) { // check visited vertexes
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j); // recursion to the same vertexes to all check vertexes
            }
        }
    }

    // Approach #3 Using Union-Find Method[Accepted]
    // Algorithm
    // Another method that can be used to determine the number of connected components in a graph is the union find
    // method. The method is simple.

    // We make use of a parent array of size NNN. We traverse over all the nodes of the graph. For every
    // node traversed, we traverse over all the nodes directly connected to it and assign them to a single group
    // which is represented by their parent node. This process is called forming a union. Every
    // group has a single parent node, whose own parent is given by -1\text{-1}-1.
    // For every new pair of nodes found, we look for the parents of both the nodes. If the parents nodes are the
    // same, it indicates that they have already been united into the same group. If the parent nodes differ, it
    // means they are yet to be united. Thus, for the pair of nodes (x,y)(x, y)(x,y), while forming the union, we
    // assign parent[parent[x]]=parent[y]parent\big[parent[x]\big]=parent[y]parent[parent[x]]=parent[y], which
    // ultimately combines them into the same group.

    // The following animation depicts the process for a simple matrix:
    // At the end, we find the number of groups, or the number of parent nodes.
    // Such nodes have their parents indicated by a -1\text{-1}-1. This gives us the required count.




    // Approach #2 Using Breadth First Search[Accepted]
    // Algorithm
    // As discussed in the above method, if we view the given matrix as an adjacency matrix of a graph, we can use
    // graph algorithms easily to find the number of connected components. This approach makes use of Breadth First
    // Search for a graph.
    // In case of Breadth First Search, we start from a particular node and visit all its directly connected nodes
    // first. After all the direct neighbours have been visited, we apply the same process to the neighbour nodes as
    // well. Thus, we exhaust the nodes of a graph on a level by level basis.
    // In this case also, we apply BFS starting from one of the nodes. We make use of a visited array to keep a track
    // of the already visited nodes. We increment the count of connected components whenever we need to start off with
    // a new node as the root node for applying BFS which hasn't been already visited.

    // Complexity Analysis
    // Time complexity : O(n^2). The complete matrix of size n^2 is traversed.
    // Space complexity : O(n). A queue and visited array of size n is used.

    private static int findCircleNumBFS(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < isConnected.length; j++) {
                        // isConnected[s][j] == 1 && visited[j] == 0) - проверка соединенных вершин матрицы
                        if (isConnected[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    }
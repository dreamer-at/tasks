package com.tasks.LeetCode.Graphs;

public class UnionByRank {

    // Time Complexity
    // Union-find       Constructor	  Find	   Union	    Connected
    // Time Complexity  O(N)  	      O(logN)  O(logN)      O(logN)

    // Note: N is the number of vertices in the graph.
    // - For the union-find constructor, we need to create two arrays of size N each.
    // - For the find operation, in the worst-case scenario, when we repeatedly union components of equal rank, the tree
    //   height will be at most log(N)+1, so the find operation requires O(logN) time.
    // - For the union and connected operations, we also need O(logN) time since these operations are dominated by the find operation.

    // Space Complexity
    // We need O(N) space to store the array of size N.

    private int[] root;
    private int[] rank;

    public UnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rootY) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                root[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionByRank ur = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        ur.union(1, 2);
        ur.union(2, 5);
        ur.union(5, 6);
        ur.union(6, 7);
        ur.union(3, 8);
        ur.union(8, 9);
        System.out.println(ur.connected(1, 5)); // true
        System.out.println(ur.connected(5, 7)); // true
        System.out.println(ur.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        ur.union(9, 4);
        System.out.println(ur.connected(4, 9)); // true
    }
}

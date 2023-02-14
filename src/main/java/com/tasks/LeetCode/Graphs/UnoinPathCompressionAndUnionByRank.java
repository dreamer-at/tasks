package com.tasks.LeetCode.Graphs;

public class UnoinPathCompressionAndUnionByRank {
    // Optimized “disjoint set” with Path Compression and Union by Rank
    // This implementation of the “disjoint set” is optimized with both “path compression” and “union by rank”.
    // Time Complexity
    // Union-find Constructor	Find	Union	Connected
    // Time Complexity O(N) остальное O(1)
    // Note:
    // N is the number of vertices in the graph.
    // α refers to the Inverse Ackermann function. In practice, we assume it's a constant. In other words,

    // O(α(N)) is regarded as
    // O(1) on average.
    // For the union-find constructor, we need to create two arrays of size
    // N each.
    // When using the combination of union by rank and the path compression optimization, the find operation will take

    // O(α(N)) time on average. Since union and connected both make calls to find and all other operations require
    //  constant time, union and connected functions will also take

    // O(α(N)) time on average.
    // Space Complexity
    // We need

    // O(N) space to store the array of size N.

    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public UnoinPathCompressionAndUnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

    // The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) throws Exception {
        UnoinPathCompressionAndUnionByRank uf = new UnoinPathCompressionAndUnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

package com.tasks.LeetCode.Graphs;

public class UnionPathCompression {

    // Time Complexity
    //Time complexities shown below are for the average case, since the worst-case scenario is rare in practice.
    //
    //Union-find Constructor	Find	Union	Connected
    //Time Complexity O(N) остальное (logN)


    // Note:
    // N is the number of vertices in the graph.
    // As before, we need

    // O(N) time to create and fill the root array.
    // For the find, union, and connected operations (the latter two operations both depend on the find operation), we need

    // O(1) time for the best case (when the parent node for some vertex is the root node itself). In the worst case,
    // it would be O(N) time when the tree is skewed. However, on average, the time complexity will be

    // O(logN). Supporting details for the average time complexity can be found in Top-Down Analysis of Path
    // Compression where R. Seidel and M. Sharir discuss the upper bound running time when path compression is used
    // with arbitrary linking.
    // Space Complexity
    // We need O(N) space to store the array of size  N.

    private int[] root;

    public UnionPathCompression(final int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]); // recursion find
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionPathCompression uf = new UnionPathCompression(10);
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

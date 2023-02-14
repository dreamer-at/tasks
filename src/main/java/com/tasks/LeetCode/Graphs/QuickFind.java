package com.tasks.LeetCode.Graphs;

public class QuickFind {

    //                              Time Complexity
    //                  Union-find
    //                  Constructor	            Find	 Union	 Connected
    // Time Complexity   O(N)                    O(1)     O(n)    O(1)
    // Note:
    // N is the number of vertices in the graph.
    // - When initializing a union-find constructor, we need to create an array of size
    // N with the values equal to the corresponding array indices; this requires linear time.
    // - Each call to find will require O(1) time since we are just accessing an element of the array at the given
    // index.
    // - Each call to union will require O(N) time because we need to traverse through the entire array and update
    // the root vertices for all the vertices of the set that is going to be merged into another set.
    // - The connected operation takes O(1) time since it involves the two find calls and the equality check operation.

    // Space Complexity
    // We need O(N) space to store the array of size N.

    private final int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1,2);
        uf.union(2,5);
        uf.union(5,6);
        uf.union(6,7);
        uf.union(3,8);
        uf.union(8,9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false

        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

}

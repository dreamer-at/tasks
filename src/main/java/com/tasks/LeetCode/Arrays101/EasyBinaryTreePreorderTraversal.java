package com.tasks.LeetCode.Arrays101;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;

public class EasyBinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new DefaultMutableTreeNode();

        System.out.println();
    }

    // Given the root of a binary tree, return the preorder traversal of its nodes' values.

    // Input: root = [1,null,2,3]
    // Output: [1,2,3]
    // Example 2:

    // Input: root = []
    // Output: []
    // Example 3:

    // Input: root = [1]
    // Output: [1]
    // Constraints:
    // The number of nodes in the tree is in the range [0, 100].
    // -100 <= Node.val <= 100

    // Follow up: Recursive solution is trivial, could you do it iteratively?
    private static List<Integer> preorderTraversal(TreeNode root) {
        return new LinkedList<>();
    }
}

package org.example.chap4TreeGraph;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class Ex4_2_Minimal_Tree {
    public static TreeNode createMinimalTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinimalTree(arr, start, mid - 1);
        root.right = createMinimalTree(arr, mid+1, end);
        return root;
    }

    // Optional: Print the tree in-order (for testing)
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createMinimalTree(sortedArray, 0, sortedArray.length - 1);
        printInOrder(root);  // Output should be the sorted array: 1 2 3 4 5 6 7
    }
}

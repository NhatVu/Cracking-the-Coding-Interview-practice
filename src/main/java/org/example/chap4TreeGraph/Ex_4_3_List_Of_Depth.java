package org.example.chap4TreeGraph;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class Ex_4_3_List_Of_Depth {

    public List<List<Integer>> listOfDepth(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }

        if (res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node_0 = new TreeNode(1);
        TreeNode node_1_1 = new TreeNode(2);
        TreeNode node_1_2 = new TreeNode(3);
        node_0.left = node_1_1;
        node_0.right = node_1_2;

        // level 3
        TreeNode node_2_1 = new TreeNode(4);
        TreeNode node_2_2 = new TreeNode(5);
        TreeNode node_2_3 = new TreeNode(6);
        TreeNode node_2_4 = new TreeNode(7);
        node_1_1.left = node_2_1;
        node_1_1.right = node_2_2;

        node_1_2.left = node_2_3;
        node_1_2.right = node_2_4;

        Ex_4_3_List_Of_Depth solution = new Ex_4_3_List_Of_Depth();
        List<List<Integer>> res = solution.listOfDepth(node_0);
        System.out.println("final value");
        for(List<Integer> arr: res){
            System.out.println(arr);
        }
    }
}

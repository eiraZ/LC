/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null ) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode node1, TreeNode node2){
        if (node1 == null) return node2==null;
        if (node2 == null) return false;
        if (node1.val != node2.val) return false;
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }

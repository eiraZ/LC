/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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

public boolean isValidBST(TreeNode root) {
        // if(root==null) return true;
        //  return isValidBST(root.left, Integer.MIN_VALUE, root.val)&&isValidBST(root.right, root.val, Integer.MAX_VALUE);
        return isValidBST(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
        
    }
public boolean isValidBST(TreeNode root, long min, long max){
    if(root==null){
        return true;
    }
    
    if(root.val<=min||root.val>=max){
        return false;
    }
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
}

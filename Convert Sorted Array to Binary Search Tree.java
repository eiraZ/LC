/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Solution: Binary Search.

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
  public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return helper(num, 0, num.length -1);
  }
  private TreeNode helper(int[] num, int left, int right){
        if (left > right) return null;
        if (left == right) return new TreeNode(num[left]);
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, left, mid - 1);
        root.right = helper(num, mid + 1, right);
        return root;
  }

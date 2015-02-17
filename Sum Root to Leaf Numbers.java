/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

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

public int sumNumbers(TreeNode root) {
    //if (root == null ) return 0;
    //int[] res = new int[1];
    return sumHelper(root, 0);
}
private int sumHelper(TreeNode root, int current){
    if (root == null) return 0;
    if (root.left == null && root.right == null){
        current = current * 10 + root.val;
        return current;
    }
    current = current * 10 + root.val;
    int left = sumHelper(root.left, current);
    int right = sumHelper(root.right, current);
    return left+ right;
}

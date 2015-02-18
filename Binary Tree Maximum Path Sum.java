/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

Solution: Recursion.
          for current node, 
          (1)calculate maxPath: 
                    leftSum + root.val + rightSum; or leftSum + root.val; or root.val + rightSum; or root.val. 
                    compare with globalMax(here it is res[0])
          (2) calculate maxSubPath for parents: leftSum + root.val; or root.val + rightSum; or root.val. 
              this is the return value
                
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

public int maxPathSum(TreeNode root) {
    //if (root == null) return 0;
    int[] res = new int[1];
    res[0] = Integer.MIN_VALUE;
    helper(root, res);
    return res[0];
    
}
private int helper(TreeNode root, int[] res){
    if (root == null) return 0;
    int left = helper(root.left, res);
    int right = helper(root.right, res);
    int curMax = root.val + Math.max(left, 0) + Math.max(right, 0);
    res[0] = Math.max(res[0], curMax);
    return root.val + Math.max(left, Math.max(right, 0));
    
}

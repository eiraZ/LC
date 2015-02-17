/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ele = new ArrayList<Integer>();
        
        pathHelper(res, ele, root, sum);
        return res;
    }
    
    private void pathHelper(List<List<Integer>> res, List<Integer> ele, TreeNode root, int sum){
        if (root == null) return;
        ele.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == sum){
                res.add(new ArrayList<Integer>(ele));
            }
            ele.remove(ele.size() - 1);
            return;
        }
        pathHelper(res, ele, root.left, sum - root.val);
        pathHelper(res, ele, root.right, sum - root.val);
        ele.remove(ele.size() - 1);
    }

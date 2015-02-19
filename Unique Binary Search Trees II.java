/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

    public List<TreeNode> generateTrees(int n) {
        return (List)helper(1, n);
        
    }
    private ArrayList<TreeNode> helper(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(left>right){
            res.add(null);
            return res;
        }
        for(int i=left; i<=right; i++){
            ArrayList<TreeNode> leftList = helper(left, i-1);
            ArrayList<TreeNode> rightList = helper(i+1, right);
            
            for(int k=0; k<leftList.size(); k++){
                for(int m=0; m<rightList.size(); m++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(k);
                    root.right = rightList.get(m);
                    res.add(root);
                }
            }
        }
        return res;
        
    }

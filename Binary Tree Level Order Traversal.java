/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

Solution: 1. BFS. Level by level
          2. DFS
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

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)   return res;
        //BFS
        List<Integer> ele = new ArrayList<>();
        ele.add(root.val);
        res.add(new ArrayList<Integer>(ele));
        
        LinkedList<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        
        while (parents.size() > 0){
            ele = new ArrayList<Integer>();
            LinkedList<TreeNode> next = new LinkedList<>();
            
            while (parents.size() > 0){
                TreeNode cur = parents.poll();
                if (cur.left!= null){
                    ele.add(cur.left.val);
                    next.add(cur.left);
                }
                if (cur.right != null){
                    ele.add(cur.right.val);
                    next.add(cur.right);
                }
            }
            if(ele.size() > 0){
                res.add(ele);
            }
            parents = next;
        }
        
        return res;
        
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)   return res;
        int level = 0;
        TreeNode cur = root;
        helper(res, root, level);
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int level){
        if(root == null)    return;
        if(res.size() == level){
            List<Integer> ele = new ArrayList<Integer>();
            res.add(ele);
        }
        List<Integer> cur = res.get(level);
        cur.add(root.val);
        helper(res, root.left, level+1);
        helper(res, root.right, level +1);
    }

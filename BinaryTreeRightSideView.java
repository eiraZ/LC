/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered
from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Solution: 1. BFS: level order traversal. Time: O(n)
          2. DFS: Time: O(n)

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
 
 public List<Integer> rightSideViewBFS(TreeNode root) {
        //level order traversal
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //res.add(root.val);
        
        while (queue.size() > 0){
            res.add(queue.get(queue.size() - 1).val);
            LinkedList<TreeNode> next = new LinkedList<>();
            
            while(queue.size()>0){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    next.offer(cur.left);
                }
                if (cur.right != null){
                    next.offer(cur.right);
                }
            }
            queue = next;
        }
        return res;
    }
    
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode root, int level){
        if(root == null)    return;

        if(res.size() == level){
            res.add(root.val);
        }
        helper(res, root.right, level+1);
        helper(res, root.left, level + 1);
        
    }

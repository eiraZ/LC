/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path
equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Solution: 1. DFS: recursion
          2. BFS: queue
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
public boolean hasPathSum1(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null && root.val == sum){
        return true;
    }
    if(hasPathSum1(root.left, sum-root.val)) return true;
    if(hasPathSum1(root.right, sum-root.val)) return true;
    return fasle;
    //return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
}

public boolean hasPathSumBFS(TreeNode root, int sum) {
        if (root == null)  return false;
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<TreeNode> treeQueue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur.val);
        treeQueue.offer(cur);
        
        while (treeQueue.size() > 0){
            TreeNode temp = treeQueue.poll();
            int curSum = queue.poll();
            if(curSum == sum && temp.left == null && temp.right == null)    return true;
            if(temp.left!= null){
                queue.offer(curSum + temp.left.val);
                treeQueue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(curSum + temp.right.val);
                treeQueue.offer(temp.right);
            }
        }
        return false;
    }

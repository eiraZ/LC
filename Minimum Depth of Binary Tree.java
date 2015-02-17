/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

public int minDepth_DFS(TreeNode root) {
    if (root == null) return 0;
    if (root.left== null){
        return 1+ minDepth(root.right);
    }
    if (root.right == null){
        return 1 + minDepth(root.left);
    }
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}

public int minDepth_BFS(TreeNode root){
    if (root==null) return 0;
    LinkedList<TreeNode> pre = new LinkedList<TreeNode>();
    int level = 1;
    pre.offer(root);
    LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
    while(pre.size()>0){
        TreeNode node = pre.poll();
        if( node.left == null && node.right ==null){
            break;
        }
        if(node.left!=null){
            cur.offer(node.left);
        }
        if(node.right!=null){
            cur.offer(node.right);
        }
        if (pre.size() ==0){
            pre = cur;
            cur = new LinkedList<TreeNode>();
            level++;
        }
    }
    return level;
}

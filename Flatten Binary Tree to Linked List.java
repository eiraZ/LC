/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Solution: preorder traversal.1. Iteration 2. Recursion
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
 public void flatten_iteration(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null){
        if (cur.right != null){
            stack.push(cur.right);
        }
        if (cur.left != null){
            cur.right = cur.left;
            cur.left = null;
        }else{
            if (!stack.empty()){
                cur.right = stack.pop();
            }
        }
        cur = cur.right;
    }
 }
 
 public void flatten_re(TreeNode root) {
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    flattenHelper(stack, root);
    
 }
 private void flattenHelper(Stack<TreeNode> stack, TreeNode root){
    if (root == null) return;
    if (root.right != null){
        stack.push(root.right);
    }
    if (root.left !=null){
        root.right = root.left;
        root.left = null;
    }
    if (root.right == null && root.left == null){
        if (stack.empty()){
            return;
        }
        root.right = stack.pop();
    }
    flattenHelper(stack. root.right);
 }

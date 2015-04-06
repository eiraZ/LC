/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: 1. Recursion
          2. Iteration using stack
          3. Morris
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null ) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root !=null || !stack.empty()){
            if (root !=null){
                res.add(root.val);
                if (root.right != null){
                    stack.push(root.right);
                }
                root = root.left;
            }else{
                root = stack.pop();
            }
        }
        return res;
    }
    
    public List<Integer> preorderTraversal_recursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root){
        if (root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
    
    public List<Integer> preorderTraversal_recursion2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root ==null) return res;
        res.add(root.val);
        List<Integer> left = preorderTraversal_recursion2(root.left);
        List<Integer> right = preorderTraversal_recursion2(root.right);
        res.addAll(left);
        res.addAll(right);
        return res;
        
    }
    
    public List<Integer> preorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        TreeNode cur = root;
        
        while (cur != null){
            if (cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == null){
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
        
    }
    
    
    
    

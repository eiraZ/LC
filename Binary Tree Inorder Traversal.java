/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

Solution: recursion: Time: O(n) Space: O(n)
          iteration: simulate stack in recursion. Time & Space: O(n)
          Morris: find precessor. Time: O(n), Space: O(1)
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

public List<Integer> inorderTraversal_recursion(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    helper(root, res);
    return res;
}
private void helper(TreeNode root, List<Integer> res){
    if(root == null ) return;
    helper(root.left, res);
    res.add(root.val);
    helper(root.right, res);
}

public List<Integer> inorderTraversal_recursion2(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    res.addAll(inorderTraversal_recursion2(root.left));
    res.add(root.val);
    res.addAll(inorderTraversal_recursion2(root.right));
    return res;
}

public List<Integer> inorderTraversal_iter(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (root != null || !stack.empty()){
        if (root != null){
            stack.push(root);
            root = root.left;
        }else{
            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }
    }
    
    return res;
    
}

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null)   return res;
        TreeNode cur = root;
        
        while(cur != null){
            if (cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
   }

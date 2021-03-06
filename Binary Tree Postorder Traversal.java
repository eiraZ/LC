/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

1. iteration
2. recursion
3. morris. we use additional data structure for reverse...

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

public List<Integer> postorderTraversal_recursion(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    helper(res, root);
    return res;
    
}
private void helper(List<Integer> res, TreeNode root){
    if (root == null) return;
    helper(res, root.left);
    helper(res, root.right);
    res.add(root.val);
}

public List<Integer> postorderTraversal_iter(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode pre = null;
    while (root != null || !stack.empty()){
        if (root != null){
            stack.push(root);
            root = root.left;
        }else{
            TreeNode cur = stack.peek();
            if (cur.right != null && cur.right != pre){
                root = cur.right;
            }else{
                stack.pop();
                res.add(cur.val);
                pre = cur;
            }
        }
    }
    return res;
}

public List<Integer> postorderTraversalMorris(TreeNode root) {
        //morris
        List<Integer> res = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode cur = dummy;
        TreeNode pre = null;
        
        while (cur != null){
            if (cur.left == null){
                cur = cur.right;
            }else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if (pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    Stack<Integer> stack = new Stack<Integer>();
                    TreeNode temp = cur.left;
                    while (temp != cur){
                        stack.push(temp.val);
                        temp = temp.right;
                    }
                    while (!stack.isEmpty()){
                        res.add(stack.pop());
                    }
                    
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
        
    }

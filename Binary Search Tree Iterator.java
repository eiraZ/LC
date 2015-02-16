/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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
public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode current;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current!=null || (!stack.empty());
        
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.empty() && current == null) return 0;
        while (current != null){
            stack.push(current);
            current = current.left;
        }
        TreeNode temp = stack.pop();
        current = temp.right;
        return temp.val;
    }
 }
 /**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
    Solution: BFS+ recursion. treat it as a linkedlist.
*/
public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode pre = dummy;
        TreeLinkNode parent = root;
        
        while (parent != null){
            if (parent.left!=null){
                pre.next = parent.left;
                pre = pre.next;
            }
            if (parent.right !=null){
                pre.next = parent.right;
                pre = pre.next;
            }
            parent = parent.next;
        }
        connect(dummy.next);
  }

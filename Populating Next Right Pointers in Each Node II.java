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
    
    Solution: 1. BFS+ recursion. treat it as a linkedlist.
              2. DFS. List<List<TreeLinkNode>> res. record last TreeLinkNode for each level.
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
  
      public void connect(TreeLinkNode root) {
        //DFS
        if(root == null)    return;
        List<List<TreeLinkNode>> res = new ArrayList<>();
        helper(res, root, 0);
        
    }
   private void helper(List<List<TreeLinkNode>> res, TreeLinkNode root, int level){
        if (root == null)   return;
        List<TreeLinkNode> ele = null;
        if (res.size() == level){
            ele = new ArrayList<TreeLinkNode>();
            ele.add(root);
            res.add(ele);
        }else{
            ele = res.get(level);
            ele.get(0).next = root;
            ele.remove(0);
            ele.add(root);
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }

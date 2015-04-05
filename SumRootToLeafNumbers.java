/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Solution: 1. DFS using recursion
          2. BFS using two queues
          3. DFS using stack: postorder

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

    public int sumNumbersDFS(TreeNode root) {
        return sumHelper(root, 0);
    }
    private int sumHelper(TreeNode root, int current){
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            current = current * 10 + root.val;
            return current;
        }
        current = current * 10 + root.val;
        int left = sumHelper(root.left, current);
        int right = sumHelper(root.right, current);
        return left+ right;
    }

    public int sumNumbersBFS(TreeNode root) {
        if (root == null)   return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> sumQueue = new LinkedList<>();
        queue.offer(root);
        sumQueue.offer(root.val);
        
        int res = 0;
        while (queue.size() > 0){
            TreeNode node = queue.poll();
            int cur = sumQueue.poll();
            if (node.left != null){
                queue.offer(node.left);
                sumQueue.offer(cur * 10 + node.left.val);
            }
            if (node.right != null){
                queue.offer(node.right);
                sumQueue.offer(cur * 10 + node.right.val);
            }
            if (node.left == null && node.right == null){
                res += cur;
            }
        }
        return res;
    }
    
        public int sumNumbersPostorderWithStack(TreeNode root) {
        if (root == null)   return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        int res = 0;
        int num = 0;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                num = num*10 + cur.val;
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode temp = stack.peek();
                if (temp.right != null && pre != temp.right){
                    cur = temp.right;
                }else{
                    if (temp.left == null && temp.right == null){
                        res += num;
                    }
                    num /= 10;
                    pre = temp;
                    stack.pop();
                }
            }
        }
        return res;
    }

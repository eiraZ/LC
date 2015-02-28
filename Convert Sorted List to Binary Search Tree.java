/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Solution: Binary search
          1. Preorder. root, root.left, root.right
          2. Inorder: divide and conquer. Recursion
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
public TreeNode sortedListToBSTPre(ListNode head) {

    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode walker = head;
    ListNode runner = head;
    ListNode pre = dummy;
    while (runner!=null && runner.next!=null){
        runner = runner.next.next;
        pre = walker;
        walker = walker.next;
    }
    ListNode l2 = walker.next;
    walker.next = null;
    
    TreeNode root = new TreeNode(walker.val);
    
    pre.next = null;
    
    root.left = sortedListToBSTPre(dummy.next);
    root.right = sortedListToBSTPre(l2);
    
    return root;
}

public TreeNode sortedListToBSTInorder(ListNode head) {
        if (head == null)   return null;
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        List<ListNode> res = new ArrayList<ListNode>();
        res.add(head);
        return helper(head, 0, count-1, res);
}
private TreeNode helper(int left, int right, List<ListNode> res){
    if (left > right)   return null;
    int mid = (left + right)/2;
    
    TreeNode leftNode = helper(left, mid-1, res);
    TreeNode root = new TreeNode(res.get(0).val);
    root.left = leftNode;
    res.set(0, res.get(0).next);
    root.right  = helper(mid+1, right, res);
    
    return root;
}

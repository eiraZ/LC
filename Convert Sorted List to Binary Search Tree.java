/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Solution: 1. Binary search
          2. Bottom-up
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
public TreeNode sortedListToBST(ListNode head) {

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
    
    root.left = sortedListToBST(dummy.next);
    root.right = sortedListToBST(l2);
    
    return root;
}

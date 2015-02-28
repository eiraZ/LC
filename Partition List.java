/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

Solution: 2 lists and connect
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

    public ListNode partition1(ListNode head, int x) {
        if (head == null)   return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = head;
        
        ListNode cur = head;
        ListNode pre1 = dummy1;
        ListNode pre2 = dummy2;
        
        while (cur != null){
            if (cur.val < x){
                pre1 = cur;
                cur = cur.next;
            }else{
                ListNode temp = cur.next;
                pre2.next = cur;
                pre2 = cur;
                cur.next = null;
                pre1.next = temp;
                cur = temp;
            }
        }
        
        pre1.next = dummy2.next;
        return dummy1.next;
    }
    
    public ListNode partition2(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode pre1 = dummy1;
        
        ListNode dummy2 = new ListNode(0);
        ListNode pre2 = dummy2;
        
        ListNode cur = head;
        //ListNode pre = dummy1;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = null;
            if (cur.val < x){
                pre1.next = cur;
                pre1 = pre1.next;
            }else{
                pre2.next = cur;
                pre2 = pre2.next;
            }
            cur = temp;
        }
        pre1.next = dummy2.next;
        return dummy1.next;
    }

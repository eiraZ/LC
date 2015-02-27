/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Solution: 2 pointers.
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
    public ListNode swapPairs(ListNode head) {
        // 1 -> 2 -> 3 ->4
        if (head == null)   return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null){
            if (cur.next == null)    break;
            ListNode move = cur.next;
            cur.next = move.next;
            pre.next = move;
            move.next = cur;
            
            pre = cur
            cur = cur.next;
        }
        
        return dummy.next;
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null)   return head;
        if (head.next == null)  return head;
        
        ListNode cur = head;
        ListNode move = cur.next;
        
        cur.next = move.next;
        move.next = cur;
        
        cur.next = swapPairs(cur.next);
        return move;
    }

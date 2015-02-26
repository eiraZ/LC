/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Solution: one pointer for N node ahead
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n==0){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode nAhead = head;
        while(n > 0){
            nAhead = nAhead.next;
            n--;
        }
        ListNode cur = dummy;
        
        //invalid
        if (n > 0){
            return null; //invalid
        }
        //valid
        while(nAhead !=null){
            nAhead = nAhead.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

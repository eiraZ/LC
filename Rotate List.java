/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Solution: if k == length of list. return head;
          if k > length of list. k = k%len
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

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)   return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        
        int k = n%count;
        ListNode ahead = dummy;
        for (int i = 0; i < k; i++){
            ahead = ahead.next;
        }
        
        cur = dummy;
        while(ahead.next != null){
            cur = cur.next;
            ahead = ahead.next;
        }
        
        ListNode l2 = cur.next;
        if (l2 == null)  return dummy.next;
        cur.next = null;
        ahead.next = head;
        
        return l2;
    }

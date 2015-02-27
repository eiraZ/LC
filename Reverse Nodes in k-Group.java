/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Solution: (1) T: # of times we need to reverse; reverse in a single group
          (2) count, reverse.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if ( k <= 1)    return head;
        int length = getLength(head);
        int T = length / k;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        
        while(T > 0){
            for (int i = 0; i<k-1; i++){
                ListNode move = cur.next;
                cur.next = move.next;
                move.next = pre.next;
                pre.next = move;
            }
            pre = cur;
            cur = cur.next;
            T--;
        }
        return dummy.next;
    }
    private int getLength(ListNode head){
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

        
        

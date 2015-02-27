/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

Solution: (1) partition: half-half; (2) reverse one list (3) connect
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
  public void reorderList(ListNode head) {
        if (head == null || head.next == null)   return;
        //partition
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next !=null){
            runner = runner.next.next;
            walker = walker.next;
        }
        ListNode l2 = walker.next;
        walker.next = null;
        
        l2 = reverseList(l2);
        //merge(head, l2);
        
        ListNode l1 = head;
        
        while (l1!=null && l2 !=null){
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            
            l1.next = l2;
            l2.next = tmp1;
            
            l1 = tmp1;
            l2 = tmp2;
        }
        
  }
  
  private ListNode reverseList(ListNode head){
        if (head == null)   return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur !=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
        
  }

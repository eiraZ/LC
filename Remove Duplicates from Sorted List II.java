/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 

Solution: one pointer for the last single node,
          2 more pointers: 
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
  public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        
        ListNode pre = head;
        ListNode runner = head.next;
        while(runner!=null){
            if(pre.val!=runner.val){
                res.next = pre;
                res = res.next;
            }else{
                while(runner!=null&&runner.val==pre.val){
                    runner = runner.next;
                }
            }
            pre = runner;
            if(runner!=null){
                runner = runner.next;
            }
        }
        
        res.next = pre; 
        
        return dummy.next;
      
  }

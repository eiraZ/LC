/*
Sort a linked list using insertion sort.
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

public ListNode insertionSortList(ListNode head) {
    if (head == null)   return null;
    ListNode dummy = new ListNode(0);
    
    ListNode runner = head;
    while(runner !=null){
        ListNode temp = runner.next;
        runner.next = null;
        ListNode pre= dummy;
        while (pre.next != null){
            if(pre.next.val <= runner.val){
                pre = pre.next;
            }else{
                runner.next = pre.next;
                pre.next = runner;
                break;
            }
        }
        if (pre.next == null)   pre.next = runner;
        runner = temp;
    }
    return dummy.next;
    
}

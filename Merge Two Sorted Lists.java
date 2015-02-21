/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 ==null ) return l1;
    
    ListNode dummy = new ListNode(0);
    dummy.next = l1;
    
    ListNode pre = dummy;
    
    while (l1!=null && l2 !=null){
        if(l1.val <= l2.val){
            pre = l1;
            l1 = l1.next;
        }else{
            ListNode temp = l2.next;
            l2.next = l1;
            pre.next = l2;
            pre = pre.next;
            l2 = temp;
        }
    }
    if (l2 !=null){
        pre.next = l2;
    }
    return dummy.next;
}

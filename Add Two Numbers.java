/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their
nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Solution: 2 pointers. carry digit!
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
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null)  return l2;
    if (l2 == null) return l1;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    
    int carry = 0;
    ListNode runner1 = l1;
    ListNode runner2 = l2;
    while (runner1 != null || runner2 != null|| carry!=0){
        int digit = carry;
        if(runner1 != null){
            digit += runner1.val;
            runner1 = runner1.next;
        }
        if (runner2 !=null){
            digit += runner2.val;
            runner2 = runner2.next;
        }
        cur.next = new ListNode(digit%10);
        carry = digit/10;
        cur = cur.next;
    }
    return dummy.next;
}

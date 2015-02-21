/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

Solution: count length. move the pointer with the same length. 
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

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null) return null;
    if(headB == null) return null;
    
    int count1 = 0;
    int count2 = 0;
    
    ListNode curA = headA;
    ListNode curB = headB;
    
    while(curA != null){
        count1++;
        curA = curA.next;
    }
    while(curB != null){
        count2++;
        curB = curB.next;
    }
    int kAhead = Math.abs(count1-count2);
    curA = headA;
    curB = headB;
    if(count1 > count2){
        while(kAhead>0){
            curA = curA.next;
            kAhead--;
        }
    }else{
        while (kAhead > 0){
            curB = curB.next;
            kAhead--;
        }
    }
    while (curA!=null && curB !=null){
        if(curA == curB){
            return curA;
        }
        curA = curA.next;
        curB = curB.next;
    }
    return null;
}

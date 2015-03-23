/*
Sort a linked list in O(n log n) time using constant space complexity.

Solution: Merge sort

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

    public ListNode sortList(ListNode head) {
        //base case: contains <=1 node!!!
        if(head == null||head.next == null)    return head;
        
        ListNode walker = head;
        ListNode runner = head.next;
        while(runner!= null && runner.next!=null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode l2 = walker.next;
        walker.next = null;
        
        ListNode m1 = sortList(head);
        ListNode m2 = sortList(l2);
        
        return merge(m1, m2);
    }
    private ListNode merge2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l2 != null){
            cur.next = l2;
        }
        if (l1 != null){
            cur.next = l1;
        }
        
        return dummy.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur2 = l1;
        ListNode pre = dummy;
        
        while (cur2!= null && l2!= null){
            if(cur2.val < l2.val){
                pre = pre.next;
                cur2 = cur2.next;
            }else{
                ListNode temp = l2.next;
                pre.next = l2;
                pre = pre.next;
                l2.next = cur2;
                l2 = temp;
            }
        }
        if(cur2 == null){
            pre.next = l2;
        }
        return dummy.next;
    }

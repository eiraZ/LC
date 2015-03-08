/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Solution: (1)Divide and Conquer. k--> 2-->merge
          (2) Priority Queue.  O(nlogk)
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
 
 public ListNode mergeKLists(List<ListNode> lists) {
    if (lists.size() == 0 ) return null;
    return helper(lists, 0, lists.size()-1);
 }
 
 private ListNode helper(List<ListNode> lists, int start, int end){
        if(start > end) return null;
        if(start == end) return lists.get(start);
        int mid = (start+end)/2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid+1, end);
        return merge(left, right);
 }
 private ListNode merge(ListNode l1, ListNode l2){
        if(l2 ==null) return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur1 = cur1.next;
                pre = pre.next;
            }else{
                ListNode temp = cur1;
                pre.next = cur2;
                cur2 = cur2.next;
                pre = pre.next;
                pre.next = temp;
            }
        }
        if (cur1==null){
            pre.next = cur2;
        }
        return dummy.next;
 }
 
 public ListNode mergeKLists_PQ(List<ListNode> lists) {
        
        if(lists ==null||lists.size()==0){
            return null;
        }
        
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                if(node1.val > node2.val)   return 1;
                else if(node1.val == node2.val) return 0;
                else return -1;
            }    
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), cmp);
        for(ListNode list: lists){
            if (list !=null){
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pq.size() > 0){
            ListNode node = pq.poll();
            cur.next = node;
            if (node.next!= null){
                pq.add(node.next);
            }
            cur = cur.next;
        }
        return dummy.next;
        
    }

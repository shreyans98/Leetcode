/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
/*
Intuition behind the approach is to initialise a min heap and then add every element of the list to the min heap.
Since it is a min heap, therefore root will be the smallest element and we can extract it and add to the new list.


*/
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //ading everything to the new priority queue
        for(ListNode ln : lists) {
            while(ln != null) {
                pq.add(ln.val);
                ln = ln.next;
            }
        }
        //list to store the sorted list
        ListNode head = new ListNode(0);
        ListNode h = head;
        
        while(!pq.isEmpty()) {
            ListNode t = new ListNode(pq.poll());
            h.next = t;
            h = h.next;
        }
        
        return head.next;
        
    }
}
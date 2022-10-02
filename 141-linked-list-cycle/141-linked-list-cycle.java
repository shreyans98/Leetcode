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
public class Solution {
    public boolean hasCycle(ListNode head) {
        
 //we will use two pointers and initialise it with head. While the fast pointer moves 2 position at a time, slow pointer moves 1 position at a time. The moment slow & fast are equal, it means a cycle is detected else no cycle is detected.       
        ListNode fast = head;
        ListNode slow = head;
        if(head == null)
            return false;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        
        return false;
        
    }
}
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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; //initialised slow pointer with head
        ListNode fast = head; //initialised fast pointer with head
        ListNode entry = head;
        
       
        
        while(fast != null && fast.next != null) { //loop traversal for checking if a cycle exists or not
            fast = fast.next.next; // fast moves by 2 position 
            slow = slow.next; //slow moves by 1 position
            
            if(fast == slow) { //if fast & slow are equal then we have cycle present in the list
                while(entry != slow) { // entry moves 1 position at a time, till it is not equal with slow pointer
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        
       
        return null;
    }
}
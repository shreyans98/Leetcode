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
    public boolean isPalindrome(ListNode head) {
        
//Approach here is to take two pointers fast and slow.

        ListNode fast = head;
        ListNode slow = head;
        // fast moves twice the speed of slow and hence reaches the end of the list when slow is at the middle of the list.
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
    //we reverse the list from the middle position where slow is upto the end of the list.
        slow = rev(slow);
        //fast is initialised with head
        fast = head;
        
        //loop to check each element of the reversed second half of the list with the first half of the list. If somewhere elements are not same then it will return false
        while(slow != null) {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    //method to reverse the second half of the list
    public ListNode rev(ListNode head) {
        ListNode reverse = null;
        while(head != null) {
            ListNode prev = head.next;
            head.next = reverse;
            reverse = head;
            head = prev;
        }
        
        return reverse;
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry ==1) {
            int s1 = (l1 != null) ? l1.val : 0;
            int s2 = (l2 != null) ? l2.val : 0;
            
            int sum = 0;
            sum = carry + s1 + s2;
            carry = sum/10;
            
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            
            if(l1 != null)
                l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;
        }
        
        return res.next;
        
    }
}
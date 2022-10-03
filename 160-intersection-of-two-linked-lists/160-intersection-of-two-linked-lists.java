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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
//We can use hashing to store the address and then check in hash if we got the same address for second list
        HashSet<ListNode> set = new HashSet<>();
        
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        
        return null;
        
    }
}
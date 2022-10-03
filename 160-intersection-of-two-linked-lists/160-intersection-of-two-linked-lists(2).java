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
        
//If the two list have intersection, then there must be a node where headA and headB will be equal(not in value) and if not then there is no intersection
        while(headB != null) {
            ListNode temp = headA;
            while(temp != null) {
                if(headB == temp)
                    return headB;
                temp = temp.next;
            }
            
            headB = headB.next;
        }
        
        return null;
        
    }
}

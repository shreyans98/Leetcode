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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
 // 1->2->3->4->5
//k =3 , only 1 part to be reversed
        
/*
We will reverse only 1 part and loop it iteratively for others

First we will break the connection b/w node 1 and node 2. Node 1 is then connected to node 3.
Second we will break the connection between node 2 & node 3. Node 2 now points to node 3

Then pre will move to next current element
Then next moves to next of current element

*/
        if(head == null || k==1)
            return head;
        ListNode dummy = new ListNode(0);
        //dummy node
        dummy.next = head;
        
        ListNode curr = dummy, prev = dummy, next = dummy; 
        int count = 0;
        
        //loop to calculate the length of list
        while(curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        while(count>=k) {
            curr = prev.next; //current node whose link we will reverse
            next = curr.next; //node where current points
            
            for(int i=0;i<k-1;i++) {
                curr.next = next.next; //we break the first link between node 1 & node 2
                next.next = prev.next; //we break the second link between node 2 & node 3
                prev.next = next; //idea is pre will point to next current element
                next = curr.next; //next is then shifted
            }
             prev = curr; //pre stands at the last node of the reversed, group of list
            count -=k;
        }
        
        return dummy.next;
        
    }
}
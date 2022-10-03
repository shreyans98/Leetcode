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
    public ListNode rotateRight(ListNode head, int k) {
        
        int count = 1;
        // if the list contains 0 or 1 elements or k =0(number of times to be rotated is 0) then return the list
        if(head == null || head.next == null || k == 0)
            return head;
        
       
        ListNode temp = head;
        while(temp.next != null){ //to count the length of the list
            temp = temp.next;
            count++;
        }
        
        temp.next = head; //created a circular linked list
         // modulous is taken, since if k is greater than length of list then we will rotate only for (k % count) times as rotating for count times will give us same list
        k = k% count;
        
        //if k is smaller then the length of the list then we have to rotate that many times, (if greater than reminder number of times)
         int end = count - k;
        
        // to obtain the break point
        while (end-- != 0)
            temp = temp.next;
        //assign the head at the break point
        head = temp.next;
        
        //break the circular linked list
        temp.next = null;
        
        return head;
                
    }
}
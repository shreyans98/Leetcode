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
        //brute force approach

//Take a stack and temp node. Assign the temp node with the head node and now till the time it is not empty keep inserting it into the stack. 
        ListNode temp = head;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        //loop for storing the value in stack till the end of the list

        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        //again assign temp to head in order to check for palindrome since we will have last value first coming out from stack 
        temp = head;
        
        //loop to check if temp value is equal or not.
        while(temp != null) {
            if(temp.val != stack.pop())
                return false;
            temp = temp.next;
        }
        
        return true;
           
    }
}
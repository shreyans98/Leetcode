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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode mlist = result;
        while(list1 != null || list2 != null) {
            if(list1 != null) {
                if(list2 == null || (list1.val < list2.val)) {
                    mlist.next = list1;
                    list1 = list1.next;
                }
                else {
                    mlist.next = list2;
                    list2 = list2.next;
                }
            } else {
                mlist.next = list2;
                list2 = list2.next;
            }
            mlist = mlist.next;
    }
        return result.next;
    }
}
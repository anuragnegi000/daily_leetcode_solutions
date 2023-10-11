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
    public ListNode reverseList(ListNode head) {
         ListNode prev = null; // Initialize a pointer to the previous node
        ListNode p1 = head; // Initialize a pointer to the current node

        while (p1 != null) {
            ListNode nextTemp;
            nextTemp=p1.next; // Store the next node
            p1.next = prev; // Reverse the direction of the current node's pointer

            // Move prev and current pointers one step forward
            prev = p1;
            p1 = nextTemp;
        }

        return prev; // The new head of the reversed list
    }
}
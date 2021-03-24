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

/*
 * ########## Iterative Approach ##########
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
*/


/* 
 * ########## Recursive Approach ###########
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode list = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return list;
    }
}

/* Notes:
 * 
 * n = number of nodes in the linked list
 * Space Complexity: O(1) since the list is reversed in place. 
 * Time Complexity:  O(n)
 * 
 * Alternative approach:
 * ### Using recursion
 * Space Complexity: O(n) due to stack recursion
 * Time Complexity: O(n) 
 *
 */

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
 * ############## Using Stack ##################
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null)
            return true;
        
        Stack<Integer> stack = new Stack<Integer>();
        ListNode ptr = head;
        while(ptr != null) {
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        
        while(head != null) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }
}

/* Notes:
 * 
 * n = number of nodes in the linked list
 * Space Complexity: O(n) since we are storing the linked list in a stack
 * Time Complexity:  O(n) since we traverse the list twice
 *
 */

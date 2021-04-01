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
    
    public int getListLength(ListNode head) {
        if (head == null)
            return 0;
        
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
            return head;
        
        int listLength = getListLength(head);
        
        ListNode old_tail = head;
        while(old_tail.next != null) {
            old_tail = old_tail.next;
        }
        
        old_tail.next = head;
        ListNode new_tail = head;
        for (int i = 0; i < listLength - k % listLength -  1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        
        return new_head;
    }
}


/* Notes:
 * 
 * n = number of nodes in the linked list
 * Space Complexity: O(1) since we are modifying the list in-place.
 * Time Complexity:  O(n) since we traverse the list once.
 *
 */

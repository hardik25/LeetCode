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
    public ListNode deleteDuplicates(ListNode head) {
        
        // Check if list is empty or list contains only one item
        if (head == null || head.next == null)
            return head;
        
        ListNode ptr = head;
        // We check for consecutive repetitions and remove duplicates until we reach the end of the list
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }
}

/* Notes:
 * 
 * n = length of the linked list
 * Space Complexity: O(1) since we modify the list in-place.
 * Time Complexity:  O(n) since we traverse the entire linked list 
 * 
 */

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
 * ############# Iterative Approach #######################
 *
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        ListNode result = new ListNode();
        ListNode resultHead = result;
        ListNode ptr1 = l1, ptr2 = l2;
        
        while(ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                result.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                result.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }
            result = result.next;
        }
        
        if (ptr1 != null && ptr2 == null)
            result.next = ptr1;
        
        if (ptr2 != null && ptr1 == null)
            result.next = ptr2;
        
        return resultHead.next;  
    }
}
*/

/*
 * ############## Recursive Approach ####################
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


/* Notes:
 * 
 * m, n = length of linked lists. 
 * Space Complexity: O(m + n) to store the result list 
 * Time Complexity:  O(m + n) to traverse the nodes of both lists 
 * 
 * Recursive Approach:
 * m, n = length of linked lists. 
 * Space Complexity: O(m + n) for stack recursion
 * Time Complexity:  O(m + n) to traverse the nodes of both lists 
 *
 */

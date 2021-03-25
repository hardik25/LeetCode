/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * ########### Using a Set to check for duplicate nodes ############
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while(head != null) {
            if (nodes.contains(head))
                return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
}
*/ 

/*
 * ############ Two pointer method (slow and fast pointers) ##########
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        
        while(fast.next != null && fast.next.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

/* Notes:
 * 
 * n = length of the linked list. 
 * Space Complexity: O(n) for the HashSet
 * Time Complexity:  O(n) it takes O(n) in the worst case since we check all nodes in the list.
 * 
 * Alternative approach:
 * Using 2 pointers method, we initialize a slow pointer and a fast pointer. 
 * The fast pointer moves by 2 and slow pointer moves by 1. 
 * If there is a cycle, these pointers will eventually meet confirming a cycle, else we will reach the end of the list.
 * Space Complexity: O(1) since no extra space is used
 * Time Complexity: O(n) since we traverse the entire list in the worst case.
 */

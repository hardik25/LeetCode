/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* 
 * ############ Using HashSet ############
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
    
        while(headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
*/


/*
 * ############ Two pointers ##############
 */
public class Solution {
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
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        
        ListNode ptr1, ptr2 = null;
        int extraNodes = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            ptr1 = headA;
            ptr2 = headB;
        } else {
            ptr1 = headB;
            ptr2 = headA;
        }
        
        while(extraNodes > 0) {
            ptr1 = ptr1.next;
            extraNodes--;
        }
        
        while(ptr1 != null) {
            if (ptr1 == ptr2) 
                return ptr1;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
}

/* Notes:
 * 
 * m, n = number of nodes in the linked lists  
 * Space Complexity: O(max(m, n)) or O(n) for the HashSet 
 * Time Complexity:  O(max(m, n)) or O(n) since we can traverse over each list once. 
 * 
 * Alternative approach: Two pointers
 * Space Complexity: O(1) since we are not using any storage
 * Time Complexity: O(n) we need to traverse each list at least once.
 */

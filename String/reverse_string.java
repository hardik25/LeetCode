class Solution {
    public void reverseString(char[] s) {
        
        int length = s.length;
        int start = 0, end = length - 1; 
        
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

/* Notes:
 * 
 * n = length of the linked list. 
 * Space Complexity: O(1) since string is reversed in-place.
 * Time Complexity:  O(n/2) 
 * 
 */

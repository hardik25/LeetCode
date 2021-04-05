class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] alphabet = new int[26];
        for (char ch: s.toCharArray()) {
            alphabet[ch - 'a']++;
        }
        
        for (char ch: t.toCharArray()) {
            alphabet[ch - 'a']--;
        }
        
        for (int i: alphabet) {
            if (i != 0)
                return false;
        }
        
        return true;
    }
}

/* Notes:
 * 
 * n = length of the strings
 * Space Complexity: O(1) since use fixed size array to store the alphabet count.
 * Time Complexity:  O(n) since we traverse each string once. 
 * 
 */

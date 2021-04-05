class Solution {
    
    public void backtrack(int n, List<Integer> list, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = first; i < n; i++) {
            Collections.swap(list, first, i);
            backtrack(n, list, output, first + 1);
            Collections.swap(list, first, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> output = new LinkedList();
        
        List<Integer> list = new ArrayList<Integer>();
        for (int num: nums) {
            list.add(num);
        }
        backtrack(nums.length, list, output, 0);
        return output;
    }
}

/* Notes:
 * 
 * This is a very important concept. 
 * 
 * N = size of the num list
 * 
 * Time Complexity: O(N!)
 * Space Complexity: O(N!) since store N! permutations
 *
 */

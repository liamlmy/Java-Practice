// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
// 
// Example:
// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        
        DFS(nums, 0, cur, result);
        return new ArrayList<>(result);
    }
    
    private void DFS(int[] nums, int index, List<Integer> cur, Set<List<Integer>> result) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        // recursion rule
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, index, i);
            DFS(nums, index + 1, cur, result);
            cur.remove(cur.size() - 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

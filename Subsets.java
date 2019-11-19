// Given a set of distinct integers, nums, return all possible subsets (the power set).
// Note: The solution set must not contain duplicate subsets.
// Example:
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(nums, cur, result, 0);
        return result;
    }

    private void DFS(int[] nums, List<Integer> cur, List<List<Integer>> result, int idx) {
    	result.add(new ArrayList<>(cur));

    	for (int i = idx; i < nums.length; i++) {
    		cur.add(nums[i]);
    		DFS(nums, cur, result, i + 1);
    		cur.remove(cur.size() - 1);
    	}
    }
}

// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Note:
// All numbers will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:
// Input: k = 3, n = 7
// Output: [[1,2,4]]
//
// Example 2:
// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(k, n, cur, result, 1);
        return result;
    }

    private void DFS(int k, int n, List<Integer> cur, List<List<Integer>> result, int num) {
    	// base case
    	if (cur.size() == k) {
    		if (n == 0) {
    			result.add(new ArrayList<>(cur));
    		}
    		return;
    	}

    	// recursion rule
    	for (int i = num; i <= 9; i++) {
    		cur.add(i);
    		DFS(k, n - i, cur, result, i + 1);
    		cur.remove(cur.size() - 1);
    	}
    }
}

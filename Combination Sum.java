// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where
// the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
// [
//   [7],
//   [2, 2, 3]
// ]

public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    List<Integer> sub = new ArrayList<>();
    DFS(candidates, target, result, sub, 0);
    return result;
  }
    
  private void DFS(int[] candidates, int target, List<List<Integer>> result, List<Integer> sub, int index) {
    // Base case
    if (target == 0) {
      result.add(new ArrayList<>(sub));
      return;
    }
    // Recursion rule
    for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
      sub.add(candidates[i]);
      DFS(candidates, target - candidates[i], result, sub, i);
      sub.remove(sub.size() - 1);
    }
  }
}

// Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
// Each number in C may only be used once in the combination.
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
// A solution set is: 
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        DFS(candidates, solution, result, target, 0);
        return result;
    }
    
    private void DFS(int[] candidates, List<Integer> solution, List<List<Integer>> result, int target, int index) {
        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }
        // Recursion rule
        solution.add(candidates[index]);
        DFS(candidates, solution, result, target - candidates[index], index + 1);
        solution.remove(solution.size() - 1);
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        DFS(candidates, solution, result, target, index + 1);
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, target, cur, result, 0);
        return new ArrayList<>(result);
    }
    
    private void DFS(int[] candidates, int target, List<Integer> cur, Set<List<Integer>> result, int index) {
        // base case
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        if (target < 0 || index == candidates.length) {
            return;
        }
        
        // recursion rule
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            DFS(candidates, target - candidates[i], cur, result, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

// Given n unique integers, number k (1<=k<=n) and target. Find all possible k integers where their sum is target.
// Example
// Given [1,2,3,4], k = 2, target = 5. Return:
// [
//   [1,4],
//   [2,3]
// ]

/*
 * Method 1: DFS
 */
public class Solution {
  public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        DFS(A, k, target, solution, result, 0);
        return result;
    }
    
    private void DFS(int[] A, int k, int target, List<Integer> solution, List<List<Integer>> result, int index) {
        // Base case
        if (solution.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(solution));
            }
            return;
        }

        // Recursion rule
        for (int i = index; i < A.length; i++) {
            solution.add(A[i]);
            DFS(A, k, target - A[i], solution, result, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}

/*
 * Method 2: DFS
 */
public class Solution {
  public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        DFS(A, k, target, solution, result, 0);
        return result;
    }
    
    private void DFS(int[] A, int k, int target, List<Integer> solution, List<List<Integer>> result, int index) {
        // Base case
        if (index == A.length) {
          if (solution.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(solution));
            }
          }
          return;
        }
        // Recursion rule
        solution.add(A[index]);
        DFS(A, k, target - A[index], solution, result, index + 1);
        solution.remove(solution.size() - 1);
        DFS(A, k, target, solution, result, index + 1);
    }
}

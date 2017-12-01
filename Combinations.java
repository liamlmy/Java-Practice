// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// For example,
// If n = 4 and k = 2, a solution is:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

/*
 * Method 1: DFS
 */
public class Solution {
  public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k < 0) {
            return result;
        }
        List<Integer> solution = new ArrayList<>();
        DFS(n, k, solution, result, 1);
        return result;
    }
    
    private void DFS(int n, int k, List<Integer> solution, List<List<Integer>> result, int cur) {
        // Base case
        if (cur > n) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        // Recursion rule
        solution.add(cur);
        DFS(n, k - 1, solution, result, cur + 1);
        solution.remove(solution.size() - 1);
        DFS(n, k, solution, result, cur + 1);
    }
}

/*
 * Method 2: DFS
 */
public class Solution {
  public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
  
	private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
    // Base case
		if(k==0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
    // Recursion rule
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(combs, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
}

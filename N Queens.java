// Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
//
// Assumptions
// N > 0
//
// Return
// A list of ways of putting the N Queens
// Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
//
// Example
// N = 4, there are two ways of putting 4 queens:
//
// [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3,
// the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.
//
// [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0,
// the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.

public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Corner check
    if (n == 0) {
      return null;
    }
    
    // Find all possible solutions
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> subSolution = new ArrayList<Integer>();
    findSolutions(result, subSolution, n);
    return result;
  }
  
  private void findSolutions(List<List<Integer>> result, List<Integer> subSolution, int n) {
    // Base case: the last row is done
    if (subSolution.size() == n) {
      result.add(new ArrayList<Integer>(subSolution));
      return;
    }
    
    // Recursion rule: when the current row is done, go to deal with next row
    for (int i = 0; i < n; i++) {
      if (check(subSolution, i)) {
        subSolution.add(i);
        findSolutions(result, subSolution, n);
        subSolution.remove(subSolution.size() - 1);
      }
    }
  }
  
  private boolean check(List<Integer> subSolution, int i) {
    int row = subSolution.size();
    for (int j = 0; j < row; j++) {
      if (subSolution.get(j) == i || i - subSolution.get(j) == row - j || i - subSolution.get(j) == j - row) {
        return false;
      }
    }
    return true;
  }
}

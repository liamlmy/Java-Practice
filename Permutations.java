// Given a collection of distinct numbers, return all possible permutations.

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // Corner check
    if (nums == null) {
      return result;
    }
    // DFS
    List<Integer> cur = new ArrayList<>();
    DFS(nums, result, cur, 0);
    return result;
  }
  
  private void DFS(int[] nums, List<List<Integer>> result, List<Integer> cur, int index) {
    // Base case
    if (index == nums.length) {
      result.add(new ArrayList(cur));
      return;
    }
    // Recursion rule
    for (int i = index; i < nums.length; i++) {
      swap(nums, i, index);
      cur.add(nums[index]);
      DFS(nums, result, cur, index + 1);
      cur.remove(cur.size() - 1);
      swap(nums, i, index);
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

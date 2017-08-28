// Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents),
// get all the possible ways to pay a target number of cents.
//
// Arguments
// coins - an array of positive integers representing the different denominations of coins,
// there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
// target - a non-negative integer representing the target number of cents, eg. 99
//
// Assumptions
// coins is not null and is not empty, all the numbers in coins are positive
// target >= 0
// You have infinite number of coins for each of the denominations, you can pick any number of the coins.
//
// Return
// a list of ways of combinations of coins to sum up to be target.
// each way of combinations is represented by list of integer,
// the number at each index means the number of coins used for the denomination at corresponding index.
//
// Examples
// coins = {2, 1}, target = 4, the return should be
// [
//   [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
//   [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
//   [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
// ]

public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Each combination is represented as a List<Integer> subSet,
    // and subSet.get(i) = the number of coins of coins[i].
    // All the combinations are stored in the reuslt as list of List<Integer>.
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> subSet = new ArrayList<Integer>();
    DFS(target, coins, result, subSet, 0);
    return result;
  }
  
  // Target: remaining cents we need to complete.
  // Coins: all the possible different coins.
  // Index: we want to see how many coins we need for coins[i].
  private void DFS(int target, int[] coins, List<List<Integer>> result, List<Integer> subSet, int index) {
    // Base case
    // This can also be done at index == coins.length where all the coins have been picked.
    // But a probably better solution is at a previous level to reduce the number of unnecessary branches in the DFS.
    // Coins.length - 1 represents the last coins we can use and actually what we can do at this level is to get
    // target / coins[coins.length - 1] coins if possilbe.
    if (index == coins.length - 1) {
      if (target % coins[coins.length - 1] == 0) {
        subSet.add(target / coins[coins.length - 1]);
        result.add(new ArrayList(subSet));
        subSet.remove(subSet.size() - 1);
      }
      return;
    }
    // Recursion rule
    int max = target / coins[index];
    for (int i = 0; i <= max; i++) {
      subSet.add(i);
      DFS(target - i * coins[index], coins, result, subSet, index + 1);
      subSet.remove(subSet.size() - 1);
    }
  }
}

// Time complexity: O(n) = O(n^(coins.length))
// Space complexity: O(coins.length) ???

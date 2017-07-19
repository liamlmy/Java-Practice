// Find all prime number in given number.

public class Solution {
  public List<Integer> allPrimeNumber(int n) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner case
    if (n < 2) {
      return result;
    }
    // Find all prime number
    for (int i = 2; i <= n; i++) {
      int sum = 0;
      for (int j = 1; j * j <= i; j++) {
        if (i % j == 0) {
          sum++;
        }
      }
      if (sum == 1) {
        result.add(i);
      }
    }
    return result;
  }
}

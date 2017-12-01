// The set [1,2,3,…,n] contains a total of n! unique permutations.
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
// Note: Given n will be between 1 and 9 inclusive.

public class Solution {
  public String getPermutation(int n, int k) {
    int[] factorial = new int[n + 1];
    factorial[0] = 1;
    int sum = 1;
    for (int i = 1; i < factorial.length; i++) {
      sum *= i;
      factorial[i] = sum;
    }
    List<Integer> pos = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      pos.add(i);
    }
    k--;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      int index = k / factorial[n - i];
      sb.append(String.valueOf(pos.get(index)));
      pos.remove(index);
      k = k - index * factorial[n - i];
    }
    return new String(sb);
  }
}

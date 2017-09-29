// Description:
// Count the number of prime numbers less than a non-negative number, n.

/*
 * Method 1
 */
public class Solution {
  public int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (notPrime[i] == false) {
        count++;
        for (int j = 2; i*j < n; j++) {
          notPrime[i*j] = true;
        }
      }
    }
    return count;
  }
}

/*
 * Method 2
 */
public class Solution {
  publib int countPrimes(int n) {
    if (n < 3) {
      return 0;
    }
    boolean[] f = new boolean[n];

    int count = n / 2;
    for (int i = 3; i * i < n; i += 2) {
      if (f[i]) {
        continue;
      }
      for (int j = i * i; j < n; j += 2 * i) {
        if (!f[j]) {
          --count;
          f[j] = true;
        }
      }
    }
    return count;
  }
}

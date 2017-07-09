// Get the Kth number in the Fibonacci Sequence.
// (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
// 
// Examples
// 0th fibonacci number is 0
// 1st fibonacci number is 1
// 2nd fibonacci number is 1
// 3rd fibonacci number is 2
// 6th fibonacci number is 8
//
// Corner Cases
// What if K < 0? in this case, we should always return 0.
// Is it possible the result fibonacci number is overflowed?
// We can assume it will not be overflowed when we solve this problem on this online judge,
// but we should also know that it is possible to get an overflowed number,
// and sometimes we will need to use something like BigInteger.

/*
 * Method 1: O(logn) solution using matrix multiplication
 * M = {{1, 1}, {1, 0}} = {{f(2), f(1)}, {f(1), f(0)}}
 * fibo(K) = (M ^ K)[0][0]
 */
public class Solution {
  public long fibonacci(int K) {
    
  }
}


/*
 * Method 2: DP method with space complexity O(n)
 */
/*
public class Solution {
  public long fibonacci(int K) {
    // Corner check
    if (K <= 0) {
      return (long) 0;
    }
    
    long[] array = new long[K + 1];
    // Base case
    array[1] = (long) 1;
    // Induction rule
    for (int i = 2; i <= K; i++) {
      array[i] = array[i - 1] + array[i - 2];
    }
    return array[K];
  }
}
*/

/*
 * Method 3: DP method with space complexity O(1)
 */
/*
public class Solution {
  public long fibonacci(int K) {
    long a = 0;
    long b = 1;
    // Base case
    if (K <= 0) {
      return a;
    }
    if (K == 1) {
      return b;
    }
    // Induction rule
    while (K > 1) {
      long temp = a + b;
      a = b;
      b = temp;
      K--;
    }
    return b;
  }
}
*/

/*
 * Method 4: Recursion method
 */
/*
public class Solution {
  public long fibonacci(int K) {
    // Base case
    if (K <= 0) {
      return (long) 0;
    }
    if (K == 1) {
      return (long) 1;
    }
    // Recursion rule
    return fabonacci(K - 1) + fabonacci(K - 2);
  }
}
*/

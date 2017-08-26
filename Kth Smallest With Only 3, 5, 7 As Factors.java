// Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
//
// Assumptions
// K >= 1
//
// Examples
// the smallest is 3 * 5 * 7 = 105
// the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
// the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
// the 5th smallest is 3 ^ 3 * 5 * 7 = 945

/*
 * Method 1: Best-First-Search
 */
/*
public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    minHeap.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);
    while (k > 1) {
      long current = minHeap.poll();
      if (visited.add(3 * current)) {
        minHeap.offer(3 * current);
      }
      if (visited.add(5 * current)) {
        minHeap.offer(5 * current);
      }
      if (visited.add(7 * current)) {
        minHeap.offer(7 * current);
      }
      k--;
    }
    return minHeap.poll();
  }
}
*/

/*
 * Method 2: Linear solution using 3 deques
 */
public class Solution {
  public long kth(int k) {
    long seed = 3 * 5 * 7L;
    // We use 3 deques to maintains all the possible values.
    // The rule is:
    // three only maintains the value of seed * 3^x.
    // five only maintains the value of seed * 3^x * 5^y.
    // seven only maintains the value of seed * 3^x * 5^y *7^z.
    Deque<Long> three = new LinkedList<>();
    Deque<Long> five = new LinkedList<>();
    Deque<Long> seven = new LinkedList<>();
    three.add(seed * 3);
    five.add(seed * 5);
    seven.add(seed * 7);
    long result = seed;
    while (k > 1) {
      // Each round, pick the smallest one from the head of 3 deques.
      // When pushing back the value into the deques, following the rule:
      // If the smallest number x is from deque three, we need to push x*3 to three, x*5 to five, x*7 to seven,
      // to maintain the properties of the three deques.
      // If the smallest number x if from deque five, we need to push x*5 to five, x*7 to seven,
      // we do not need to push x*3 to three again, because x*3 has already been generated before.
      // Similarly, we only need to push x*7 to seven if the smallest number x is from seven.
      if (three.peekFirst() < five.peekFirst() && three.peekFirst() < seven.peekFirst()) {
        result = three.poll();
        three.offerLast(result * 3);
        five.offerLast(result * 5);
        seven.offerLast(result * 7);
      } else if (five.peekFirst() < three.peekFirst() && five.peekFirst() < seven.peekFirst()) {
        result = five.poll();
        five.offerLast(result * 5);
        seven.offerLast(result * 7);
      } else {
        result = seven.poll();
        seven.offerLast(result * 7);
      }
      k--;
    }
    return result;
  }
}

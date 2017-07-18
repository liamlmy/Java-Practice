// Given a string, find the longest substring without any repeating characters and return the length of it.
// The input string is guaranteed to be not null.
//
// For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

public class Solution {
  public int longest(String input) {
    Set<Character> set = new HashSet<Character>();
    int result = 0;
    int fast = 0;
    int slow = 0;
    while (fast < input.length()) {
      if (set.contains(input.charAt(fast))) {
        // If there is duplicate character, we need to move the slow pointer.
        set.remove(input.charAt(slow));
        slow++;
      } else {
        // If there is no duplicate character, we can slide fast pointer and we have a new slide window of
        // (slow, fast) containing all distinct characters.
        set.add(input.charAt(fast));
        fast++;
        result = Math.max(result, fast - slow);
      }
    }
    return result;
  }
}

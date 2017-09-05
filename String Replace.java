// Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
//
// Assumptions
// input, S and T are not null, S is not empty string
//
// Examples
// input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
// input = "dodododo", S = "dod", T = "a", input becomes "aoao"

public class Solution {
  public String replace(String input, String s, String t) {
		char[] array = input.toCharArray();
		if (s.length() >= t.length()) {
			return replaceShort(array, s, t);
		}
		return replaceLong(array, s, t);
	}

	private String replaceShort(char[] input, String s, String t) {
		// We reuse the input char array since the number of characters needed is less.
    // Fast and slow pointers both from left to right direction.
    int fast = 0;
    int slow = 0;
    while (fast < input.length) {
      // When we find a match of s on the substring starting form the fast pointer,
      // we copy the t at slow pointer
      if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
        copySubstring(input, slow, t);
        slow += t.length();
        fast += s.length();
      } else {
        input[slow] = input[fast];
        slow++;
        fast++;
      }
    }
    return new String(input, 0, slow);
	}
  
  private String replaceLong(char[] input, String s, String t) {
    // Notice: we will need a longer array in this case, and if the requirement is "in place",
    // usually you can assume you are given a long enough char array already, and the original
    // input string resides on part of the char array starting from index 0.
    // In this solution, we actually allocate a larger array on demand, and the purpose of the
    // solution is to demonstrate how to do it "in place".
    
    // Get all matches end positions in the input char array of string s.
    ArrayList<Integer> matches = getAllMatches(input, s);
    // Calculate the new length needed.
    char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
    // Fast and slow pointers both from right to left direction.
    // Fast: the position when traversing the new length.
    // Slow: the position when traversing the old length.
    // LastIndex: the rightmost matching end position's index.
    int lastIndex = matches.size() - 1;
    int slow = input.length - 1;
    int fast = result.length - 1;
    while (slow >= 0) {
      // Only if we still have some match and slow is in the position of rightmost matching end
      // position, we should copy t.
      if (lastIndex >= 0 && slow == matches.get(lastIndex)) {
        copySubstring(result, fast - t.length() + 1, t);
        fast -= t.length();
        slow -= s.length();
        lastIndex--;
      } else {
        result[fast--] = input[slow--];
      }
    }
    return new String(result);
  }
  
  private boolean equalSubstring(char[] input, int fromIndex, String s) {
    for (int i = 0; i < s.length(); i++) {
      if (input[fromIndex + i] != s.charAt(i)) {
        return false;
      }
    }
    return true;
  }
  
  private void copySubstring(char[] result, int fromIndex, String t) {
    for (int i = 0; i < t.length(); i++) {
      result[fromIndex + i] = t.charAt(i);
    }
  }
  
  private ArrayList<Integer> getAllMatches(char[] input, String s) {
    ArrayList<Integer> matches = new ArrayList<Integer>();
    int i = 0;
    while (i <= input.length - s.length()) {
      if (equalSubstring(input, i, s)) {
        // We record the match substring's end index instead of start index,
        // for later convenience.
        matches.add(i + s.length() - 1);
        i += s.length();
      } else {
        i++;
      }
    } 
    return matches;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)

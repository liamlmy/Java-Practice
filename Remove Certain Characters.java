// Remove given characters in input string, the relative order of other characters should be remained.
// Return the new string after deletion.
//
// Assumptions
// The given input string is not null.
// The characters to be removed is given by another string, it is guranteed to be not null.
//
// Examples
// input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".

public class Solution {
  public String remove(String input, String t) {
    char[] array = input.toCharArray();
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    int end = 0;
    for (int i = 0; i < array.length; i++) {
      if (!set.contains(array[i])) {
        array[end] = array[i];
        end++;
      }
    }
    return new String(array, 0, end);
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(1)

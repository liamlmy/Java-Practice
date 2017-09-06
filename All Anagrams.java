// Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
//
// Assumptions
// s is not null or empty.
// l is not null.
//
// Examples
// l = "abcbac", s = "ab", 
// return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").

public class Solution {
  public List<Integer> allAnagrams(String s, String l) {
    List<Integer> result = new ArrayList<Integer>();
    // Corner check
    if (l.length() == 0) {
      return result;
    }
    if (s.length() > l.length()) {
      return result;
    }
    // Find all occurrence of anagrams
    // This map records for each of the distinct characters in s, how many characters are needed.
    // when we get an instance of 'a' in l, we let count of 'a' decremented by 1, and only when
    // the count is from 1 to 0, we have totally matched.
    Map<Character, Integer> map = getMap(s);
    // Record how many distinct characters have been matched.
    // Only when all the distinct characters are matched, A.K.A.
    // match == map.size(), we find an anagram.
    int match = 0;
    // We have a sliding window of size s.length(), and sine the size is fixed, we only need to record
    // the end index of the sliding window.
    // Also, when move the sliding window by one step from left to right, what we only need to change is:
    // 1. remove the leftmost character at the previous sliding window.
    // 2. add the rightmost character at the current sliding window.
    for (int i = 0; i < l.length(); i++) {
      // Handle the new added character(rightmost) at the current sliding window.
      char temp = l.charAt(i);
      Integer count = map.get(temp);
      if (count != null) {
        // The number of needed count should be --.
        // And only when the count is from 1 to 0, we find an additional match of distinct character.
        map.put(temp, count - 1);
        if (count == 1) {
          match++;
        }
      }
      // Handle the leftmost character at the previous sliding window.
      if (i >= s.length()) {
        temp = l.charAt(i - s.length());
        count = map.get(temp);
        if (count != null) {
          // The number of needed count should be ++.
          // And only when the count is from 0 to 1, we are short for one match of distinct character.
          map.put(temp, count + 1);
          if (count == 0) {
            match--;
          }
        }
      }
      // For the current sliding window, if all the distinct characters are matched (the count are all 0)
      if (match == map.size()) {
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }
  
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> result = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      Integer count = result.get(s.charAt(i));
      if (count == null) {
        result.put(s.charAt(i), 1);
      } else {
        result.put(s.charAt(i), count + 1);
      }
    }
    return result;
  }
}

// Time complexity: O(n) = O(n)
// Space complexity: O(n) = O(n)

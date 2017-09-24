// Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
//
// Assumptions
// The given word is not null and is not empty
// The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
//
// Examples
// Dictionary: {“bob”, “cat”, “rob”}
// Word: “robob” return false
// Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Assumption: 
    // input is not null or empty
    // dict is not null or empty
    // All strings in dict are not null or empty
    Set<String> set = toSet(dict);
    int length = input.length();
    // checkBreak[i] represents index i-1 in input, also can represent the substring(0, i)
    boolean[] checkBreak = new boolean[length + 1];
    checkBreak[0] = true;
    for (int i = 1; i <= length; i++) {
      for (int j = 0; j < i; j++) {
        if (checkBreak[j] == true && set.contains(input.substring(j, i))) {
          checkBreak[i] = true;
          break;
        }
      }
    }
    return checkBreak[length];
  }
  
  private Set<String> toSet(String[] dict) {
    Set<String> result = new HashSet<String>();
    for (String s : dict) {
      result.add(s);
    }
    return result;
  }
}

// Time complexity: O(n ^ 3)
// Space complexity: O(n)

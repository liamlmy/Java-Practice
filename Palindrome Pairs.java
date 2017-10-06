// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
// so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

public class Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    // Corner check
    if (words == null || words.length < 2) {
      return result;
    }
    Map<String, Integer> map = getMap(words);
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j <= words[i].length(); j++) {
        String str1 = words[i].substring(0, j);
        String str2 = words[i].substring(j);
        if (palindrome(str1)) {
          String candidate = new StringBuilder(str2).reverse().toString();
          if (map.containsKey(candidate) && map.get(candidate) != i) {
            List<Integer> sub = new ArrayList<>();
            sub.add(map.get(candidate));
            sub.add(i);
            result.add(sub);
          }
        }
        if (palindrome(str2)) {
          String candidate = new StringBuilder(str1).reverse().toString();
          if (map.containsKey(candidate) && map.get(candidate) != i && str2.length() != 0) {
            List<Integer> sub = new ArrayList<>();
            sub.add(i);
            sub.add(map.get(candidate));
            result.add(sub);
          }
        }
      }
    }
    return result;
  }
  
  private Map<String, Integer> getMap(String[] words) {
    Map<String, Integer> result = new HashMap<String, Integer>();
    for (int i = 0; i < words.length; i++) {
      result.put(words[i], i);
    }
    return result;
  }
  
  private boolean palindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}

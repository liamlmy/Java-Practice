// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// add spaces in s to construct a sentence where each word is a valid dictionary word.
// You may assume the dictionary does not contain duplicate words.
// Return all such possible sentences.
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
// A solution is ["cats and dog", "cat sand dog"].
//
// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings).
// Please reload the code definition to get the latest changes.

public class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = getDict(wordDict);
    Map<String, List<String>> map = new HashMap<>();
    return DFS(s, dict, map);
  }
  
  private List<String> DFS(String s, Set<String> dict, Map<String, List<String>> map) {
    // Base case
    if (map.containsKey(s)) {     // s have been checked before
      return map.get(s);
    }
    List<String> cur = new LinkedList<>();
    if (s.length() == 0) {        // s is all done
      cur.add("");
      return cur;
    }
    // Recursion rule
    for (String word : dict) {
      if (s.startsWith(word)) {
        List<String> sub = DFS(s.substring(word.length()), dict, map);
        for (String st : sub) {
          cur.add(word + (st.isEmpty() ? "" : " ") + st);
        }
      }
    }
    map.put(s, cur);
    return cur;
  }
  
  private Set<String> getDict(List<String> wordDict) {
    Set<String> dict = new HashSet<>();
    for (String word : wordDict) {
      dict.add(word);
    }
    return dict;
  }
}

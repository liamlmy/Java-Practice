// Given two words (beginWord and endWord), and a dictionary's word list,
// find the length of shortest transformation sequence from beginWord to endWord, such that:
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//
// For example,
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// UPDATE (2017/1/20):
// The wordList parameter had been changed to a list of strings (instead of a set of strings).
// Please reload the code definition to get the latest changes.

public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> reached = new HashSet<>();
    Set<String> dict = getDict(wordList);
    reached.add(beginWord);
    int distance = 1;
    while (!reached.contains(endWord)) {
      Set<String> toAdd = new HashSet<>();
      for (String each : reached) {
        for (int i = 0; i < each.length(); i++) {
          char[] array = each.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            array[i] = c;
            String candidate = new String(array);
            if (dict.contains(candidate)) {
              toAdd.add(candidate);
              dict.remove(candidate);
            }
          }
        }
      }
      distance++;
      if (toAdd.size() == 0) {
        return 0;
      }
      reached = toAdd;
    }
    return distance;
  }
  
  private Set<String> getDict(List<String> wordList) {
    Set<String> dict = new HashSet<>();
    for (String str : wordList) {
      dict.add(str);
    }
    return dict;
  }
}

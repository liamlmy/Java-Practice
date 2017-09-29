// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    // Base case
    if (strs == null) {
      return new ArrayList<>();
    }
    // Use iteration and HashMap
    Map<String, List<String>> map = new HashMap<>();
    int[] table = new int[26];
    for (String s : strs) {
      Arrays.fill(table, 0);
      for (Character c : s.toCharArray()) {
        table[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append("#");
        sb.append(table[i]);
      }
      String key = sb.toString();
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }
    return new ArrayList(map.values());
  }
}

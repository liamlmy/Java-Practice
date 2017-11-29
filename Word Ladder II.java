// Given two words (beginWord and endWord), and a dictionary's word list,
// find all shortest transformation sequence(s) from beginWord to endWord, such that:
// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:
// Return an empty list if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.

public class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    List<String> solution = new ArrayList<>();
    Map<String, List<String>> nodeNeighbor = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    Set<String> dict = new HashSet<>(wordList);
    dict.add(beginWord);
    for (String str : dict) {
      nodeNeighbor.put(str, new ArrayList<String>());
    }
    BFS(beginWord, endWord, dict, nodeNeighbor, distance);
    DFS(beginWord, endWord, dict, nodeNeighbor, distance, solution, result);
    return result;
  }
  
  private void BFS(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbor, Map<String, Integer> distance) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    distance.put(beginWord, 0);
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean flag = false;
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        int curDistance = distance.get(cur);
        List<String> neighbor = getNei(cur, dict);
        for (String nei : neighbor) {
          nodeNeighbor.get(cur).add(nei);
          if (!distance.containsKey(nei)) {
            distance.put(nei, curDistance + 1);
            if (nei.equals(endWord)) {
              flag = true;
            } else {
              queue.offer(nei);
            }
          }
        }
      }
      if (flag) {
        break;
      }
    }
  }
  
  private void DFS(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbor, Map<String, Integer> distance, List<String> solution, List<List<String>> result) {
    // Base case
    if (beginWord.equals(endWord)) {
      solution.add(beginWord);
      result.add(new ArrayList<>(solution));
      solution.remove(solution.size() - 1);
      return;
    }
    // Recursion rule
    solution.add(beginWord);
    for (String nei : nodeNeighbor.get(beginWord)) {
      if (distance.get(nei) == distance.get(beginWord) + 1) {
        DFS(nei, endWord, dict, nodeNeighbor, distance, solution, result);
      }
    }
    solution.remove(solution.size() - 1);
  }
  
  private List<String> getNei(String cur, Set<String> dict) {
    List<String> result = new ArrayList<>();
    char[] array = cur.toCharArray();
    for (char ch = 'a'; ch <= 'z'; ch++) {
      for (int i = 0; i < array.length; i++) {
        if (array[i] == ch) {
          continue;
        } else {
          char old = array[i];
          array[i] = ch;
          if (dict.contains(String.valueOf(array))) {
            result.add(String.valueOf(array));
          }
          array[i] = old;
        }
      }
    }
    return result;
  }
}

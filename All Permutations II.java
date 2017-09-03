// Given a string with possible duplicate characters, return a list with all permutations of the characters.
//
// Examples
// Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
// Set = "aba", all permutations are ["aab", "aba", "baa"]
// Set = "", all permutations are [""]
// Set = null, all permutations are []

public class Solution {
  public List<String> permutations(String set) {
    List<String> result = new ArrayList<String>();
    // Corner check
    if (set == null) {
      return result;
    }
    // Depth-first-searching
    char[] array = set.toCharArray();
    DFS(array, result, 0);
    return result;
  }
  
  // Index: at the level of index, we are to determine for the current permutation,
  // which element is positioned at the index.
  private void DFS(char[] array, List<String> result, int index) {
    // Base case
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    // Recursion rule
    // Notice: the rule is just for the current level, if a certain element is picked,
    // we cannot pick any of its duplicates. So we use a set to record all the elements.
    Set<Character> set = new HashSet<Character>();
    for (int i = index; i < array.length; i++) {
      // Use add() will return false if the element is already in the set.
      if (set.add(array[i])) {
        swap(array, index, i);
        DFS(array, result, index + 1);
        swap(array, index, i);
      }
    }
  }
  
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// Time complexity: O(n) = O(n!)
// Space complexity: O(n) = O(n)

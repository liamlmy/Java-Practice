// Given a string with no duplicate characters, return a list with all permutations of the characters.
//
// Examples
// Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
// Set = "", all permutations are [""]
// Set = null, all permutations are []

/*
 * Method 1: DFS with StringBuilder
 */
/*
public class Solution {
  public List<String> permutations(String set) {
    List<String> result = new ArrayList<String>();
    // Corner check
    if (set == null) {
      return result;
    }
    // Depth-first-searching
    char[] array = set.toCharArray();
    StringBuilder subSet = new StringBuilder();
    DFS(array, subSet, result, 0);
    return result;
  }
  
  private void DFS(char[] array, StringBuilder subSet, List<String> result, int depth) {
    // Base case
    if (depth == array.length) {
      result.add(subSet.toString());
      return;
    }
    // Recursion rule
    for (int i = depth; i < array.length; i++) {
      subSet.append(array[i]);
      swap(array, i, depth);
      DFS(array, subSet, result, depth + 1);
      int end = subSet.length();
      subSet.deleteCharAt(end - 1);
      swap(array, i, depth);
    }
  }
  
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
*/

/*
 * Method 2: DFS without StringBuilder
 */
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
  
  private void DFS(char[] array, List<String> result , int depth) {
    // Base case
    if (depth == array.length) {
      result.add(new String(array));
      return;
    }
    // Recursion rule
    for (int i = depth; i < array.length; i++) {
      swap(array, i, depth);
      DFS(array, result, depth + 1);
      swap(array, i, depth);
    }
  }
  
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// Given a set of characters represented by a String, return a list containing all subsets of the characters.
//
// Assumptions
// There are no duplicate characters in the original set.
//
// Examples
// Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
// Set = "", all the subsets are [""]
// Set = null, all the subsets are []

/*
 * Method 1: DFS
 */
/*
public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<String>();
    // Corner case
    if (set == null) {
      return result;
    }
    // Depth-first-searching
    char[] array = set.toCharArray();
    StringBuilder subSet = new StringBuilder();
    DFS(array, result, subSet, 0);
    return result;
  }
  
  private void DFS(char[] array, List<String> result, StringBuilder subSet, int depth) {
    // Base case
    if (depth >= array.length) {
      result.add(subSet.toString());
      return;
    }
    // Recursion rule
    subSet.append(array[depth]);
    DFS(array, result, subSet, depth + 1);
    int end = subSet.length();
    subSet.deleteCharAt(end - 1);
    DFS(array, result, subSet, depth + 1);
  }
}
*/

/*
 * Method 2: Another DFS
 */
public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<String>();
    // Corner case
    if (set == null) {
      return result;
    }
    // Depth-first-searching
    char[] array = set.toCharArray();
    StringBuilder subSet = new StringBuilder();
    DFS(array, result, subSet, 0);
    return result;
  }
  
  private void DFS(char[] array, List<String> result, StringBuilder subSet, int depth) {
    result.add(subSet.toString());
    // Maintains ascending order of the indices of picked characters.
    // Choose the next picked index(the smallest one can be picked is index).
    for (int i = depth; i < array.length; i++) {
      subSet.append(array[i]);
      DFS(array, result, subSet, i + 1);
      subSet.deleteCharAt(subSet.length() - 1);
    }
  }
}

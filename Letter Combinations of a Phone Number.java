// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

/*
 * Method 1
 */
public class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<String>();
    }
    // Use a queue
    String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    Queue<String> queue = new LinkedList<>();
    queue.offer("");
    for (int i = 0; i < digits.length(); i++) {
      int num = digits.charAt(i) - '0';
      while (queue.peek().length() == i) {
        String pre = queue.poll();
        for (char c : map[num].toCharArray()) {
          queue.offer(pre + c);
        }
      }
    }
    List<String> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      result.add(queue.poll());
    }
    return result;
  }
}

/*
 * Method 2
 */
public class Solution {
  final String[] keyboard = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    // Corner check
    if (digits == null || digits.length() == 0) {
      return result;
    }
    // DFS
    StringBuilder sb = new StringBuilder();
    DFS(result, sb, digits, 0);
    return result;
  }
  
  private void DFS(List<String> result, StringBuilder sb, String digits, int index) {
    // Base case
    if (index == digits.length()) {
      result.add(new String(sb.toString()));
      return;
    }
    // Recursion rule
    String temp = keyboard[digits.charAt(index) - '0'];
    for (int i = 0; i < temp.length(); i++) {
      sb.append(temp.charAt(i));
      DFS(result, sb, digits, index + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

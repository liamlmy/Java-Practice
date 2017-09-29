// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

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

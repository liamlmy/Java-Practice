// The count-and-say sequence is the sequence of integers with the first five terms as following:
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth term of the count-and-say sequence.
//
// Note: Each term of the sequence of integers will be represented as a string

public class Solution {
  public String countAndSay(int n) {
    StringBuilder cur = new StringBuilder("1");
    StringBuilder prev;
    int count;
    char say;
    for (int i = 1; i < n; i++) {
      prev = cur;
      cur = new StringBuilder();
      count = 1;
      say = prev.charAt(0);
      
      for (int j = 1, len = prev.length(); j < len; j++) {
        if (prev.charAt(j) != say) {
          cur.append(count).append(say);
          count = 1;
          say = prev.charAt(j);
        } else {
          count++;
        }
      }
      cur.append(count).append(say);
    }
    return cur.toString();
  }
}

// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
// (left and right) justified.
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
// spaces ' ' when necessary so that each line has exactly L characters.
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
// divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
// For the last line of text, it should be left justified and no extra space is inserted between words.
//
// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.
//
// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.

public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
        
    int index = 0;
    while (index < words.length) {
      // Step 1: determine the index of the first word in current line and next line;
      int count = words[index].length();  // count: the length of characters in current line
      int last = index + 1;   // last: next word's index in words
      while (last < words.length) {
        if (words[last].length() + count + 1 > maxWidth) {
          break;
        }
        count += words[last].length() + 1;
        last++;
      }
      // Step 2
      StringBuilder sb = new StringBuilder();
      int diff = last - index - 1;    // diff: the number of intervals in current line
      if (last == words.length || diff == 0) {  // if current line is the last line or current line has no intervals --> left
        for (int i = index; i < last; i++) {
          sb.append(words[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        for (int i = sb.length(); i < maxWidth; i++) {
          sb.append(" ");
        }
      } else {  // otherwise --> middle
        int spaces = (maxWidth - count) / diff;   // spaces: the number of spaces in each interval of current line
        int r = (maxWidth - count) % diff;        // how many intervals should add one more space
        for (int i = index; i < last; i++) {
          sb.append(words[i]);
          if (i < last - 1) {
            for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
              sb.append(" ");
            }
          }
        }
      }
      result.add(new String(sb.toString()));
      index = last;
    }
    return result;
  }
}

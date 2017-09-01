// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
// American keyboard like the image below.

public class Solution {
  public String[] findWords(String[] words) {
    Set<Character> row1 = new HashSet<>();
    Set<Character> row2 = new HashSet<>();
    Set<Character> row3 = new HashSet<>();    
    row1.add('q');
    row1.add('w');
    row1.add('e');
    row1.add('r');
    row1.add('t');
    row1.add('y');
    row1.add('u');
    row1.add('i');
    row1.add('o');
    row1.add('p');
        
    row2.add('a');
    row2.add('s');
    row2.add('d');
    row2.add('f');
    row2.add('g');
    row2.add('h');
    row2.add('j');
    row2.add('k');
    row2.add('l');
        
    row3.add('z');
    row3.add('x');
    row3.add('c');
    row3.add('v');
    row3.add('b');
    row3.add('n');
    row3.add('m');
        
    List<String> result = new ArrayList<>();
    for(String word : words) {
      char[] charArray = word.toLowerCase().toCharArray();
      int lenOfWord = charArray.length;
      int count = 0;
      for (Character ch : charArray) {
        if (row1.contains(ch)) {
          count++;
        } else {
          break;
        }
      }
      if (count == lenOfWord) {
        result.add(word);
        continue;
      }
      count = 0;
      for (Character ch : charArray) {
        if(row2.contains(ch)) {
          count++;
        } else {
          break;
        }
      }
      if (count == lenOfWord) {
        result.add(word);
        continue;
      }
      count = 0;
      for (Character ch : charArray) {
        if (row3.contains(ch)) {
          count++;
        } else {
          break;
        }
      }
      if (count == lenOfWord) {
        result.add(word);
      }
    }
    return result.toArray(new String[result.size()]);
  }
}

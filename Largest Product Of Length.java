// Given a dictionary containing many words, find the largest product of two words’ lengths,
// such that the two words do not share any common characters.
//
// Assumptions
// The words only contains characters of 'a' to 'z'
// The dictionary is not null and does not contains null string, and has at least two strings
// If there is no such pair of words, just return 0
//
// Examples
// dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)

public class Solution {
  public int largestProduct(String[] dict) {
    // Get the bit mask for each of the word in the dictionary,
    // the bit mask is represented by the lowest 26 bits of an integer.
    // Each of the bit represents one of the characters in 'a' - 'z'
    HashMap<String, Integer> map = getBitMask(dict);
    Arrays.sort(dict, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return 0;
        }
        return s1.length() < s2.length() ? 1 : -1;
      }
    });
    int largest = 0;
    // Note the order of constructing all the pairs, we make our best to try largest product
    for (int i = 1; i < dict.length; i++) {
      for (int j = 0; j < i; j++) {
        // Early break if the product is already smaller than the current largest one.
        if (largest >= dict[i].length() * dict[j].length()) {
          break;
        }
        int iMask = map.get(dict[i]);
        int jMask = map.get(dict[j]);
        // If two words do not share any common characters, the bit masks "and" result should be 0 since
        // there is not any position such that in the two bit masks they are all 1.
        if ((iMask & jMask) == 0) {
          largest = dict[i].length() * dict[j].length();
        }
      }
    }
    return largest;
  }
  
  // Get the bit mask for each of the words.
  private HashMap<String, Integer> getBitMask(String[] dict) {
    HashMap<String, Integer> bitMask = new HashMap<>();
    for (String s : dict) {
      int mask = 0;
      for (int i = 0; i < s.length(); i++) {
        // The 26 characters 'a' - 'z' are mapped to 0 - 25th bit.
        // To determine which bit it is for a character x,
        // use (x - 'a') since their values are in a consecutive range.
        // If character x existes in the word, we set the bit at corresponding index to 1.
        mask |= 1 << (s.charAt(i) - 'a');
      }
      bitMask.put(s, mask);
    }
    return bitMask;
  }
}

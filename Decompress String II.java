// Given a string in compressed form, decompress it to the original string. 
// The adjacent repeated characters in the original string are compressed to have the character 
// followed by the number of repeated occurrences.
//
// Assumptions
// The string is not null
// The characters used in the original string are guaranteed to be ‘a’ - ‘z’
// There are no adjacent repeated characters with length > 9
//
// Examples
// “a1c0b2c4” → “abbcccc”

/*
 * Use in-place method, two pointers
 */
class Solution {
  public String decompress(String input) {
    char[] array = input.toCharArray();
    /* 
     * In this problem, there are two basic situation:
     * First one is that the decompressed string is shorter than the input string
     * Second one is that the decompressed string is longer than the input string
     */
    return decompressLong(array, decompressShort(array));
  }
  
  /*
   * Decompress the charactors which are shorter than 2 and return the length of the decompressed string
   */
  private int decompressShort(char[] array) {
    int end = 0;
    for (int i = 0; i < array.length; i += 2) {
      int digit = getDigit(array, i + 1);
      if (digit >= 0 && digit <= 2) {             //If the digit is >= 0 and <= 2, decompress it
        for (int j = 0; j < digit; j++) {         //This will not influence the length of the string
          array[end] = array[i];
          end++;
        }
      } else {                                    //Otherwise, just do not do any operation
        array[end] = array[i];
        end++;
        array[end] = array[i + 1];
        end++;
      }
    }
    return end;
  }
  
  /*
   * Decompress the remaining digits in the string which are > 2 but <= 9
   * Return the decompressed string
   */
  private String decompressLong(char[] array, int length) {
    /*
     * Find the decompressed string's length
     */
    int newLength = length;
    for (int i = 0; i < length; i++) {
      int digit = getDigit(array, i);
      if (digit > 2 && digit <= 9) {
        newLength += digit - 2;
      }
    }
    
    /*
     * New a char array with the decompressed string's length and decompress the remaining digits
     */
    char[] result = new char[newLength];
    int end = newLength - 1;
    for (int i = length - 1; i >= 0; i--) {
      int digit = getDigit(array, i);
      if (digit > 2 && digit <= 9) {
        i--;
        for (int j = 0; j < digit; j++) {
          result[end] = array[i];
          end--;
        }
      } else {
        result[end] = array[i];
        end--;
      }
    }
    return new String(result);
  }
  
  /*
   * Return the digital char in the input string
   */
  private int getDigit(char[] array, int i) {
    return array[i] - '0';
  }
}

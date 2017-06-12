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

class Solution {
  public String decompress(String input) {
    char[] array = input.toCharArray();
    return decompressLong(array, decompressShort(array));
  }
  
  private int decompressShort(char[] array) {
    int end = 0;
    for (int i = 0; i < array.length; i += 2) {
      int digit = getDigit(array, i + 1);
      if (digit >= 0 && digit <= 2) {
        for (int j = 0; j < digit; j++) {
          array[end] = array[i];
          end++;
        }
      } else {
        array[end] = array[i];
        end++;
        array[end] = array[i + 1];
        end++;
      }
    }
    return end;
  }
  
  private String decompressLong(char[] array, int length) {
    int newLength = length;
    for (int i = 0; i < length; i++) {
      int digit = getDigit(array, i);
      if (digit > 2 && digit <= 9) {
        newLength += digit - 2;
      }
    }
    
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
  
  private int getDigit(char[] array, int i) {
    return array[i] - '0';
  }
}

// Given a string, you need to reverse the order of characters in each word within a sentence
// while still preserving whitespace and initial word order.
//
// Example:
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
// Note: In the string, each word is separated by single space and there will not be any extra space in the string.

public class Solution {
  public String reverseWords(String s) {
		int i = 0;
		int j = 0;
		char[] array = s.toCharArray();
		while (j < array.length) {
			if (j == array.length - 1) {
				reverse(array, i, j);
				j++;
			} else if (array[j] == ' ' || j == array.length - 1) {
				reverse(array, i, j - 1);
				j++;
				i = j;
			} else {
				j++;
			}
		}
		return new String(array);
	}
	
	private void reverse(char[] array, int i, int j) {
		while (i < j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}
}

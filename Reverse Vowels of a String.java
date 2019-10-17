// Write a function that takes a string as input and reverse only the vowels of a string.
//
// Example 1:
// Input: "hello"
// Output: "holle"
//
// Example 2:
// Input: "leetcode"
// Output: "leotcede"
// Note:
// The vowels does not include the letter "y".

class Solution {
	private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] result = new char[s.length()];
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
        	char ci = s.charAt(i);
        	char cj = s.charAt(j);
        	if (!vowels.contains(ci)) {
        		result[i++] = ci;
        	} else if (!vowels.contains(cj)) {
        		result[j--] = cj;
        	} else {
        		result[i++] = cj;
        		result[j--] = ci;
        	}
        }
        return new String(result);
    }
}

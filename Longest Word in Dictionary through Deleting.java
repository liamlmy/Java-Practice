// Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
//
// Example 1:
// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
// Output: 
// "apple"
// Example 2:
// Input:
// s = "abpcplea", d = ["a","b","c"]
//
// Output: 
// "a"
// Note:
// All the strings in the input will only contain lower-case letters.
// The size of the dictionary won't exceed 1,000.
// The length of all the strings in the input won't exceed 1,000.

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
        	int resultLen = result.length();
        	int strLen = str.length();
        	if (resultLen > strLen || resultLen == strLen && result.compareTo(str) < 0) {
        		continue;
        	}

        	if (isSubString(str, s)) {
        		result = str;
        	}
        }

        return result;
    }

    private boolean isSubString(String str, String s) {
    	int i = 0;
    	int j = 0;
    	while (i < str.length() && j < s.length()) {
    		if (str.charAt(i) == s.charAt(j)) {
    			i++;
    			j++;
    		} else {
    			j++;
    		}
    	}
    	return i == str.length() ? true : false;
    }
}

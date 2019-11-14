// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
//
// Example 1:
// Input: "2-1-1"
// Output: [0, 2]
// Explanation: 
// ((2-1)-1) = 0 
// (2-(1-1)) = 2
//
// Example 2:
// Input: "2*3-4*5"
// Output: [-34, -14, -10, -10, 10]
// Explanation: 
// (2*(3-(4*5))) = -34 
// ((2*3)-(4*5)) = -14 
// ((2*(3-4))*5) = -10 
// (2*((3-4)*5)) = -10 
// (((2*3)-4)*5) = 10

class Solution {
	private Map<String, List<Integer>> dict = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (dict.containsKey(input)) {
        	return dict.get(input);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
        	char c = input.charAt(i);
        	if (c == '+' || c == '-' || c == '*') {
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        		for (Integer l : left) {
        			for (Integer r : right) {
        				if (c == '+') {
        					result.add(l + r);
        				} else if (c == '-') {
        					result.add(l - r);
        				} else if (c == '*') {
        					result.add(l * r);
        				}
        			}
        		}
        	}
        }
        if (result.size() == 0) {
        	result.add(Integer.valueOf(input));
        }
        dict.put(input, result);
        return result;
    }
}

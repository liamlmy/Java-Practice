// Given a string, sort it in decreasing order based on the frequency of characters.
//
// Example 1:
// Input:
// "tree"
// Output:
// "eert"
//
// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//
// Example 2:
// Input:
// "cccaaa"
// Output:
// "cccaaa"
//
// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
//
// Example 3:
// Input:
// "Aabb"
// Output:
// "bbAa"
//
// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = getFreqMap(s);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
        	@Override
        	public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
        		return e2.getValue().compareTo(e1.getValue());
        	}
        });

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
        	maxHeap.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
        	Map.Entry<Character, Integer> entry = maxHeap.poll();
        	char c = entry.getKey();
        	int v = entry.getValue();
        	for (int i = 0; i < v; i++) {
        		sb.append(c);
        	}
        }

        return sb.toString();
    }

    private Map<Character, Integer> getFreqMap(String s) {
    	Map<Character, Integer> freqMap = new HashMap<>();
    	for (char c : s.toCharArray()) {
    		freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    	}
    	return freqMap;
    }
}

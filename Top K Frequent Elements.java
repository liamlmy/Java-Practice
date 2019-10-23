// Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
// Example 2:
// Input: nums = [1], k = 1
// Output: [1]
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = getFreqMap(nums);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>(){
        	@Override
        	public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
        		return e1.getValue().compareTo(e2.getValue());
        	}
        });

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        	if (minHeap.size() < k) {
        		minHeap.offer(entry);
        	} else {
        		if (minHeap.peek().getValue() < entry.getValue()) {
        			minHeap.poll();
        			minHeap.offer(entry);
        		}
        	}
        }

        return getResult(minHeap);
    }

    private Map<Integer, Integer> getFreqMap(int[] nums) {
    	Map<Integer, Integer> freqMap = new HashMap<>();
    	for (int val : nums) {
    		freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
    	}
    	return freqMap;
    }

    private List<Integer> getResult(PriorityQueue<Map.Entry<Integer, Integer>> minHeap) {
    	List<Integer> result = new ArrayList<>();
    	while (!minHeap.isEmpty()) {
    		result.add(minHeap.poll().getKey());
    	}
    	Collections.reverse(result);
    	return result;
    }
}

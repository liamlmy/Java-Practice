// Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.
//
// Assumptions
// the composition is not null and is not guaranteed to be sorted
// K >= 1 and K could be larger than the number of distinct words in the composition, in this case, 
// just return all the distinct words

// Return
// a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

// Examples
// Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
// Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
// Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Corner check
    if (combo.length == 0) {
      return new String[0];
    }
    
    // Get the top k frequent characters
    Map<String, Integer> freqMap = getFreqMap(combo);
    
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e1.getValue().compareTo(e2.getValue());
      }
    });
    
    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
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
  
  private Map<String, Integer> getFreqMap(String[] combo) {
    Map<String, Integer> freqMap = new HashMap<>();
    for (String s : combo) {
      Integer freq = freqMap.get(s);
      if (freq == null) {
        freqMap.put(s, 1);
      } else {
        freqMap.put(s, freq + 1);
      }
    }
    
    return freqMap;
  }
  
  private String[] getResult(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
    String[] result = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      result[i] = minHeap.poll().getKey();
    }
    
    return result;
  }
}

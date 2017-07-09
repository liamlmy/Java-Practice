// Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
//
// You will have to implement the following two methods for the class
//
// read(int value) - read one value from the flow
// median() - return the median at any time, return null if there is no value read so far
//
// Examples
// read(1), median is 1
// read(2), median is 1.5
// read(3), median is 2
// read(10), median is 2.5
// ......

public class Solution {
  private PriorityQueue<Integer> largerHalf;
  private PriorityQueue<Integer> smallerHalf;
  
  public Solution() {
    // We care about the smallest number of the larger half and largerst number of smaller half.
    // So for the smaller half we use a max heap, and for the larger half we use a min heap.
    largerHalf = new PriorityQueue<Integer>();
    smallerHalf = new PriorityQueue<Integer>(11, Collections.reverseOrder());
  }
  
  public void read(int value) {
    // We maintain the property:
    // size(smaller half) == size(larger half), when there are even number of values read,
    // of size(smaller half) == size(larger half) + 1, when there are odd number of value read.
    if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
      smallerHalf.offer(value);
    } else {
      largerHalf.offer(value);
    }
    if (smallerHalf.size() - largerHalf.size() >= 2) {
      largerHalf.offer(smallerHalf.poll());
    } else if (largerHalf.size() > smallerHalf.size()) {
      smallerHalf.offer(largerHalf.poll());
    }
  }
  
  public Double median() {
    int size = size();
    if (size == 0) {
      return null;
    } else if (size % 2 == 0) {
      return (largerHalf.peek() + smallerHalf.peek()) / 2.0;
    } else {
      return (double) (smallerHalf.peek());
    }
  }
  
  private int size() {
    return smallerHalf.size() + largerHalf.size();
  }
}

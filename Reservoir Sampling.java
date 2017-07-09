// Consider an unlimited flow of data elements. How do you sample one element from this flow,
// such that at any point during the processing of the flow, you can return a random element
// from the n elements read so far.
//
// You will implement two methods for a sampling class:
//
// read(int value) - read one number from the flow
// sample() - return at any time the sample, if n values have been read,
// the probability of returning any one of the n values is 1/n, return null(Java)/INT_MIN(C++)
// if there is no value read so far
// You may need to add more fields for the class.

public class Solution {
  int count;          // How many numbers have been read so far.
  Integer sample;     // Only need to maintain the current sample.
  
  // Initialization, count is initialized as 0 since there is no single number read at the beginning.
  public Solution() {
    this.count = 0;
    this.sample = null;
  }
  
  public void read(int value) {
    count++;
    // Each number which have been read have the same probability to be the sample.
    int prob = (int) (Math.random() * count);
    if (prob == 0) {
      sample = value;
    }
  }
  
  public Integer sample() {
    return sample;
  }
}

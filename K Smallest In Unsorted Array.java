// Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
//
// Assumptions
// A is not null
// K is >= 0 and smaller than or equal to size of A
// Return
// an array with size K containing the K smallest numbers in ascending order
//
// Examples
// A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}

/*
 * Method 1: k sized max heap
 */
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Corner case
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
    // Find the k smallest elements
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        if (a.equals(b)) {
          return 0;
        }
        return a > b ? -1 : 1;
      }
    });
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else {
        if (array[i] < maxHeap.peek()) {
          maxHeap.poll();
          maxHeap.offer(array[i]);
        }
      }
    }
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = maxHeap.poll();
    }
    return result;
  }
}

/*
 * Method 2: Quick sort
 */
/*
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Corner check
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
    // Find the k smallest elements
    quickSort(array, 0, array.length - 1);
    int[] result = Arrays.copyOf(array, k);
    return result;
  }
  
  private void quickSort(int[] array, int start, int end) {
    // Base case
    if (start >= end) {
      return;
    }
    // Recursion rule
    int piv = partition(array, start, end);
    quickSort(array, start, piv - 1);
    quickSort(array, piv + 1, end);
  }
  
  private int partition(int[] array, int start, int end) {
    int piv = start + (int) (Math.random() * (end - start));
    int pivot = array[piv];
    swap(array, piv, end);
    int i = start;
    int j = end - 1;
    while (i <= j) {
      if (array[i] < pivot) {
        i++;
      } else if (array[j] >= pivot) {
        j--;
      } else {
        swap(array, i, j);
      }
    }
    swap(array, i, end);
    return i;
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
*/

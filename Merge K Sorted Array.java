// Merge K sorted array into one big sorted array in ascending order.
//
// Assumptions
// The input arrayOfArrays is not null, none of the arrays is null either.

public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
    int length = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] array = arrayOfArrays[i];
      length += array.length;
      if (array.length != 0) {
        minHeap.offer(new Entry(i, 0, array[0]));
      }
    }
    int[] result = new int[length];
    int cur = 0;
    while (!minHeap.isEmpty()) {
      Entry temp = minHeap.poll();
      result[cur++] = temp.value;
      if (temp.y + 1 < arrayOfArrays[temp.x].length) {
        temp.y++;
        temp.value = arrayOfArrays[temp.x][temp.y];
        minHeap.offer(temp);
      }
    }
    return result;
  }
  
  static class MyComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
      if (e1.value == e2.value) {
        return 0;
      }
      return e1.value < e2.value ? -1 : 1;
    }
  }
  
  static class Entry {
    int x;        // the row
    int y;        // the column
    int value;    // the value = arrayOfArrays[x][y]
    Entry(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
}

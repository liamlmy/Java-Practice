// Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space.
// Find the coordinates of the points that is k-th closest to <0,0,0>.
// We are using euclidean distance here.
//
// Assumptions
// The three given arrays are not null or empty
// K >= 1 and K <= a.length * b.length * c.length
// Return
// a size 3 integer list, the first element should be from the first array, the second element should be from the second array
// and the third should be from the third array
//
// Examples
// A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
// The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
// The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)

public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k * 2, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> x, List<Integer> y) {
        long distanceX = distance(x, a, b, c);
        long distanceY = distance(y, a, b, c);
        if (distanceX == distanceY) {
          return 0;
        }
        return distanceX < distanceY ? -1 : 1;
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0, 0);
    visited.add(cur);
    minHeap.offer(cur);
    while (k > 0) {
      cur = minHeap.poll();
      List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (n.get(0) < a.length && visited.add(n)) {
        minHeap.offer(n);
      }
      n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (n.get(1) < b.length && visited.add(n)) {
        minHeap.offer(n);
      }
      n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (n.get(2) < c.length && visited.add(n)) {
        minHeap.offer(n);
      }
      k--;
    }
    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);
    return cur;
  }
  
  private long distance(List<Integer> list, int[] a, int[] b, int[] c) {
    long dist = 0;
    dist += a[list.get(0)] * a[list.get(0)];
    dist += b[list.get(1)] * b[list.get(1)];
    dist += c[list.get(2)] * c[list.get(2)];
    return dist;
  }
}

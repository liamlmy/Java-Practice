// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

public class Solution {
  public int maxPoints(Point[] points) {
    if (points.length <= 0) {
      return 0;
    }
    if (points.length <= 2) {
      return points.length;
    }
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      map.clear();
      int samePoint = 0;
      int max = 0;
      for (int j = i + 1; j < points.length; j++) {
        int x = points[i].x - points[j].x;
        int y = points[i].y - points[j].y;
        if (x == 0 && y == 0) {
          samePoint++;
          continue;
        }
        int gcd = getGCD(x, y);
        if (gcd != 0) {
          x /= gcd;
          y /= gcd;
        }
        if (map.containsKey(x)) {
          if (map.get(x).containsKey(y)) {
            map.get(x).put(y, map.get(x).get(y) + 1);
          } else {
            map.get(x).put(y, 1);
          }
        } else {
          Map<Integer, Integer> m = new HashMap<>();
          m.put(y, 1);
          map.put(x, m);
        }
        max = Math.max(max, map.get(x).get(y));
      }
      result = Math.max(result, max + samePoint + 1);
    }
    return result;
  }
  
  private int getGCD(int x, int y) {
    if (y == 0) {
      return x;
    }
    return getGCD(y, x % y);
  }
}

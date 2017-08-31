// Given an array of 2D coordinates of points (all the coordinates are integers),
// find the largest number of points that can be crossed by a single line in 2D space.
//
// Assumptions
// The given array is not null and it has at least 2 points
//
// Examples
// <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)

public class Solution {
  public int most(Point[] points) {
    int result = 0;
    // We use each pair of points to form a line.
    for (int i = 0; i <points.length; i++) {
      // Any line can be represented by a point and a slope.
      // We take the point as seed and try to find all possible slopes.
      Point seed = points[i];
      // Record the points with same <x, y>.
      int same = 1;
      // Record the points with same x, for the special case of infinite slope.
      int sameX = 0;
      // Record the maximum number of points on the same line crossing the seed point.
      int most = 0;
      // A map with all possible slopes.
      HashMap<Double, Integer> cnt = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        Point temp = points[j];
        if (temp.x == seed.x && temp.y == seed.y) {
          // Handle the points with same <x, y>.
          same++;
        } else if (temp.x == seed.x) {
          // Handle the points with same x.
          sameX++;
        } else {
          // Otherwise, just calculate the slope and increment the counter for the calculated slope.
          double slope = ((temp.y - seed.y) + 0.0) / (temp.x - seed.x);
          if (!cnt.containsKey(slope)) {
            cnt.put(slope, 1);
          } else {
            cnt.put(slope, cnt.get(slope) + 1);
          }
          most = Math.max(most, cnt.get(slope));
        }
      }
      most = Math.max(most, sameX) + same;
      result = Math.max(result, most);
    }
    return result;
  }
}

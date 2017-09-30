// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    int len = intervals.size();
    int[] starts = new int[len];
    int[] ends = new int[len];
    for (int i = 0; i < len; i++) {
      starts[i] = intervals.get(i).start;
      ends[i] = intervals.get(i).end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    List<Interval> result = new ArrayList<>();
    for (int i = 0, j = 0; i < len; i++) {
      if (i == len - 1 || starts[i + 1] > ends[i]) {
        result.add(new Interval(starts[j], ends[i]));
        j = i + 1;
      }
    }
    return result;
  }
}

class Interval {
  int start;
  int end;
  Interval() {
    start = 0;
    end = 0;
  }
  Interval(int s, int e) {
    start = s;
    end = e;
  }
}

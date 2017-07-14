// Given a matrix of size N x M. For each row the elements are sorted in ascending order,
// and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
//
// Assumptions
// the matrix is not null, N > 0 and M > 0
// K > 0 and K <= N * M
//
// Examples
// { {1,  3,   5,  7},
//   {2,  4,   8,  9},
//   {3,  5,  11, 15},
//   {6,  8,  13, 18} }
// the 5th smallest number is 4
// the 8th smallest number is 6

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int M = matrix.length;
    int N = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell a, Cell b) {
        if (a.value == b.value) {
          return 0;
        }
        return a.value < b.value ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[M][N];
    visited[0][0] = true;
    minHeap.offer(new Cell(matrix[0][0], 0, 0));
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.row + 1 < M && !visited[cur.row + 1][cur.column]) {
        minHeap.offer(new Cell(matrix[cur.row + 1][cur.column], cur.row + 1, cur.column));
        visited[cur.row + 1][cur.column] = true;
      }
      if (cur.column + 1 < N && !visited[cur.row][cur.column + 1]) {
        minHeap.offer(new Cell(matrix[cur.row][cur.column + 1], cur.row, cur.column + 1));
        visited[cur.row][cur.column + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
  
  static class Cell {
    public int value;
    public int row;
    public int column;
    public Cell(int value, int row, int column) {
      this.value = value;
      this.row = row;
      this.column = column;
    }
  }
}

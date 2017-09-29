// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
// 11110
// 11010
// 11000
// 00000
// Answer: 1
//
// Example 2:
// 11000
// 11000
// 00100
// 00011
// Answer: 3

public class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        count += sink(grid, i, j);
      }
    }
    return count;
  }
  
  private int sink(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
      return 0;
    }
    grid[i][j] = '0';
    sink(grid, i + 1, j);
    sink(grid, i - 1, j);
    sink(grid, i, j + 1);
    sink(grid, i, j - 1);
    return 1;
  }
}

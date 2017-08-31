// Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell.
// For each pair of cells on the corridor, there must exist one and only one path between them.
// (Randomly means that the solution is generated randomly, and whenever the program is executed,
// the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.
//
// Assumptions
// N = 2K + 1 and K >= 0
// the top left corner must be corridor
// there should be as many corridor cells as possible
// for each pair of cells on the corridor, there must exist one and only one path between them
//
// Examples
// N = 5, one possible maze generated is
//         0  0  0  1  0
//         1  1  0  1  0
//         0  1  0  0  0
//         0  1  1  1  0
//         0  0  0  0  0

public class Solution {
  public int[][] maze(int n) {
    int[][] maze = new int[n][n];
    // Initialize the matrix as only (0, 0) is corridor, other cells are all walls at the beginning.
    // Later we are trying to break the walls to form corridors.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          maze[i][j] = 0;
        } else {
          maze[i][j] = 1;
        }
      }
    }
    generate(maze, 0, 0);
    return maze;
  }
  
  private void generate(int[][] maze, int x, int y) {
    // Get a random shuffle of all the possible directions, and followed the shuffled order to do DFS & backtrack.
    Dir[] dirs = Dir.values();
    shuffle(dirs);
    for (Dir dir : dirs) {
      // Advance by two steps.
      int nextX = dir.moveX(x, 2);
      int nextY = dir.moveY(y, 2);
      if (isValidWall(maze, nextX, nextY)) {
        // Only if the cell is wall (meaning we have not visited before),
        // we break the wall through to make it corridors.
        maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
        maze[nextX][nextY] = 0;
        generate(maze, nextX, nextY);
      }
    }
  }
  
  // Get a random order of the directions.
  private void shuffle(Dir[] dirs) {
    for (int i = 0; i < dirs.length; i++) {
      int index = (int) (Math.random() * (dirs.length - i));
      Dir temp = dirs[i];
      dirs[i] = dirs[i + index];
      dirs[i + index] = temp;
    }
  }
  
  // Check if the position (x, y) is within the maze and it is a wall.
  private boolean isValidWall(int[][] maze, int x, int y) {
    return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
  }
  
  enum Dir {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
    
    int deltaX;
    int deltaY;
    
    Dir(int deltaX, int deltaY) {
      this.deltaX = deltaX;
      this.deltaY = deltaY;
    }
    
    public int moveX(int x, int times) {
      return x + times * deltaX;
    }
    
    public int moveY(int y, int times) {
      return y + times * deltaY;
    }
  }
}

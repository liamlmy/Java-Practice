// Given a gym with k pieces of equipment and some obstacles.
// We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair
// to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment,
// ‘O’ denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle.
// You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle.
// The cost of moving from one cell to its neighbor is 1. You cannot put the chair on a cell with equipment or obstacle.
//
// Assumptions
// There is at least one equipment in the gym
// The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
// It is guaranteed that each 'C' cell is reachable from all 'E' cells.
// If there does not exist such place to put the chair, just return null (Java) empty vector (C++)
//
// Examples
// { { 'E', 'O', 'C' },
//   {  'C', 'E',  'C' },
//   {  'C',  'C',  'C' } }
// we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2,
// which is minimal.

public class Solution {
  private static final char EQUIP = 'E';
  private static final char OB = 'O';
  
  public List<Integer> putChair(char[][] gym) {
    int M = gym.length;
    int N = gym[0].length;
    // Use a matrix to record the sum of the shortest path cost from each Cell to all the 'E' cells.
    int[][] cost = new int[M][N];
    for (int i = 0; i < gym.length; i++) {
      for (int j = 0; j < gym[0].length; j++) {
        if (EQUIP == gym[i][j]) {
          // Use the BFS to calculate the shortest path cost form each of the equipments to all the other reachable
          // cells and add the cost to each corresponding cell.
          // Note the return boolean value represents if there exists another 'E' cell not reachable from the current
          // one, if so, there won't exists a cell to place the chair.
          if (!addCost(cost, gym, i, j)) {
            return null;
          }
        }
      }
    }
    // Find the cell with smallest sum of shorted path costs to all the 'E' cells.
    List<Integer> result = null;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (EQUIP != gym[i][j] && OB != gym[i][j]) {
          if (result == null) {
            result = Arrays.asList(i, j);
          } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
            result.set(0, i);
            result.set(1, j);
          }
        }
      }
    }
    return result;
  }
  
  private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
    // Use a boolean matrix to make sure each cell will be visited no more than once.
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    int pathCost = 1;
    Breadth-First-Search, record the current path cost.
    Queue<Pair> queue = new LinkedList<>();
    visited[i][j] = true;
    queue.offer(new Pair(i, j));
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        Pair cur = queue.poll();
        List<Pair> neis = getNeis(cur, gym);
        for (Pair nei : neis) {
          if (!visited[nei.i][nei.j]) {
            visited[nei.i][nei.j] = true;
            cost[nei.i][nei.j] += pathCost;
            queue.offer(nei);
          }
        }
      }
      pathCost++;
    }
    // If there exist another 'E' cell not reachable from the path start 'E' cell, we return false.
    for (int a = 0; a < gym.length; a++) {
      for (int b = 0; b < gym[0].length; b++) {
        if (!visited[a][b] && EQUIP == gym[a][b]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private List<Pair> getNeis(Pair cur, char[][] gym) {
    int x = cur.i;
    int y = cur.j;
    int M = gym.length;
    int N = gym[0].length;
    List<Pair> neis = new ArrayList<>();
    if (x + 1 < M && OB != gym[x + 1][y]) {
      neis.add(new Pair(x + 1, y));
    }
    if (y + 1 < N && OB != gym[x][y + 1]) {
      neis.add(new Pair(x, y + 1));
    }
    if (x - 1 >= 0 && OB != gym[x - 1][y]) {
      neis.add(new Pair(x - 1, y));
    }
    if (y - 1 >= 0 && OB != gym[x][y - 1]) {
      neis.add(new Pair(x, y - 1));
    }
    return neis;
  }
    
  static class Pair {
    int i;
    int j;
      
    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}

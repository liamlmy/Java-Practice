// In an N by N square grid, each cell is either empty (0) or blocked (1).
//
// A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
//
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
// C_1 is at location (0, 0) (ie. has value grid[0][0])
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
// Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
//
// Example 1:
// Input: [[0,1],[1,0]]
// Output: 2
// Example 2:
// Input: [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
//
// Note:
// 1 <= grid.length == grid[0].length <= 100
// grid[r][c] is 0 or 1

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
	    int n = grid.length;
	    int m = grid[0].length;
	    int[][] dp = new int[n][m];
	    Queue<int[]> queue = new LinkedList<>();
	    if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) {
	    	return -1;
	    }
	    if(grid[0][0] == 0) {
	        queue.add(new int[]{0,0});    
	        dp[0][0] = 1;
	    }
	    
	    while(queue.size() > 0) {
	        Queue<int[]> nextQueue = new LinkedList<>();
	        while(queue.size() > 0) {
	            int[] cur = queue.poll();
	            for(int i = -1; i <= 1; ++i) {
	                for(int j = -1; j <= 1; ++j) {
	                    if(i == 0 && j == 0) {
	                    	continue;
	                    }
	                    int nextx = cur[0] + i;
	                    int nexty = cur[1] + j;
	                    if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= m) {
	                    	continue;
	                    }
	                    if(grid[nextx][nexty] != 0) {
	                    	continue;
	                    }
	                    if(dp[nextx][nexty] == 0 || dp[cur[0]][cur[1]] + 1 < dp[nextx][nexty]) {
	                        dp[nextx][nexty] = dp[cur[0]][cur[1]] + 1;                     
	                        nextQueue.add(new int[]{nextx, nexty});
	                    }
	                }
	            }
	        }
	        queue = nextQueue;
	    }
	    
	    return dp[n-1][m-1] == 0 ? -1 : dp[n-1][m-1];
	}
}

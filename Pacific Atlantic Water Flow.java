// Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
// Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
// Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
// Note:
// The order of returned grid coordinates does not matter.
// Both m and n are less than 150.
//
// Example:
// Given the following 5x5 matrix:
//
//   Pacific ~   ~   ~   ~   ~ 
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * Atlantic
//
// Return:
// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

class Solution {
	int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return result;
        }
        boolean[][] PO = new boolean[matrix.length][matrix[0].length];
        boolean[][] AO = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
        	DFS(matrix, PO, i, 0);
        	DFS(matrix, AO, i, matrix[0].length - 1);
        }
        for (int j = 0; j < matrix[0].length; j++) {
        	DFS(matrix, PO, 0, j);
        	DFS(matrix, AO, matrix.length - 1, j);
        }

        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (AO[i][j] == true && PO[i][j] == true) {
        			List<Integer> cur = new ArrayList<>();
        			cur.add(i);
        			cur.add(j);
        			result.add(cur);
        		}
        	}
        }
        return result;
    }

    private void DFS(int[][] matrix, boolean[][] ocean, int i, int j) {
    	ocean[i][j] = true;
    	for (int[] d : direction) {
    		int ni = i + d[0];
    		int nj = j + d[1];
    		if (ni >= 0 && ni < matrix.length && nj >=0 && nj < matrix[0].length) {
    			if (ocean[ni][nj] == false && matrix[i][j] <= matrix[ni][nj]) {
    				DFS(matrix, ocean, ni, nj);
    			}
    		}
    	}
    }
}

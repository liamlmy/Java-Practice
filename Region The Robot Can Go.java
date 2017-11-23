// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
// 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return BFS(threshold, visited, rows, cols, 0, 0);
    }
    
    private int BFS(int threshold, boolean[][] visited, int rows, int cols, int i, int j) {
        // Base case
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        if (visited[i][j] || !check(i, j, threshold)) {
            return 0;
        }
        // Recursion rule
        visited[i][j] = true;
        return 1 + BFS(threshold, visited, rows, cols, i + 1, j) + BFS(threshold, visited, rows, cols, i - 1, j) +
                   BFS(threshold, visited, rows, cols, i, j + 1) + BFS(threshold, visited, rows, cols, i, j - 1);
    }
    
    private boolean check(int i, int j, int threshold) {
        int count = 0;
        while (i != 0) {
            count += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            count += j % 10;
            j = j / 10;
        }
        return count <= threshold;
    }
}

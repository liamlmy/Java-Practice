// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
// For example, given the following matrix:
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 6.

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] heights = new int[N];
        int area = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            area = Math.max(area, maxArea(heights));
        }
        return area;
    }
    
    private int maxArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekFirst()] > h) {
                int top = heights[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                area = Math.max(area, top * (i - left));
            }
            stack.offerFirst(i);
        }
        return area;
    }
}

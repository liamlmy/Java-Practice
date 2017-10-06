// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
// A partially filled sudoku which is valid.
//
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> row = new HashSet<>();
      Set<Character> col = new HashSet<>();
      Set<Character> cube = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.' && !row.add(board[i][j])) {
          return false;
        }
        if (board[j][i] != '.' && !col.add(board[j][i])) {
          return false;
        }
        int rowIndex = 3 * (i / 3);
        int colIndex = 3 * (i % 3);
        if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
          return false;
        }
      }
    }
    return true;
  }
}

// Given a 2D board and a list of words from the dictionary, find all words in the board.
// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
// or vertically neighboring. The same letter cell may not be used more than once in a word.
//
// For example,
// Given words = ["oath","pea","eat","rain"] and board =
//
// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// Return ["eat","oath"].
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

public class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, result);
      }
    }
    return result;
  }
  
  private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
    char c = board[i][j];
    // Base case
    if (c == '#' || root.next[c - 'a'] == null) {
      return;
    }
    root = root.next[c - 'a'];
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    // Recursion rule
    board[i][j] = '#';
    if (i > 0) {
      dfs(board, i - 1, j, root, result);
    }
    if (j > 0) {
      dfs(board, i, j - 1, root, result);
    }
    if (i < board.length - 1) {
      dfs(board, i + 1, j, root, result);
    }
    if (j < board[0].length - 1) {
      dfs(board, i, j + 1, root, result);
    }
    board[i][j] = c;
  }
  
  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (node.next[c - 'a'] == null) {
          node.next[c - 'a'] = new TrieNode();
        }
        node = node.next[c - 'a'];
      }
      node.word = word;
    }
    return root;
  }
  
  class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }
}

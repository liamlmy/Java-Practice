// Implement a trie with insert, search, and startsWith methods.
//
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.

class Trie {
  TrieNode root;
  
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }
    
  /** Inserts a word into the trie. */
  // Time complexity: O(n) = word.length()
  // Space complexity: O(n) = word.length()
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char cur = word.charAt(i);
      if (!node.containsKey(cur)) {
        node.put(cur, new TrieNode());
      }
      node = node.get(cur);
    }
    node.setEnd();
  }
  
  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char cur = word.charAt(i);
      if (!node.containsKey(cur)) {
        return null;
      }
      node = node.get(cur);
    }
    return node;
  }
  
  /** Returns if the word is in the trie. */
  // Time complexity: O(n) = word.length()
  // Space complexity: O(1)
  public boolean search(String word) {
    TrieNode result = searchPrefix(word);
    return result != null && result.isEnd();
  }
    
  /** Returns if there is any word in the trie that starts with the given prefix. */
  // Time complexity: O(n) = word.length()
  // Space complexity: O(1)
  public boolean startsWith(String prefix) {
    TrieNode result = searchPrefix(prefix);
    return result != null;
  }
}

class TrieNode {
  TrieNode[] list;
  boolean isEnd;
  final int R = 26;
  
  public TrieNode() {
    list = new TrieNode[R];
  }
  
  public void setEnd() {
    isEnd = true;
  }
  
  public boolean isEnd() {
    return isEnd;
  }
  
  public boolean containsKey(char ch) {
    return list[ch - 'a'] != null;
  }
  
  public void put(char ch, TrieNode node) {
    list[ch - 'a'] = node;
  }
  
  public TrieNode get(char ch) {
    return list[ch - 'a'];
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

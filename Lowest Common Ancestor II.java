// Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
//
// Assumptions
// There is parent pointer for the nodes in the binary tree
// The given two nodes are not guaranteed to be in the binary tree
//
// Examples
//         5
//
//       /   \
//
//      9     12
//
//    /  \      \
//
//   2    3      14
// The lowest common ancestor of 2 and 14 is 5
// The lowest common ancestor of 2 and 9 is 9
// The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int lenOne = length(one);
    int lenTwo = length(two);
    
    if (lenOne >= lenTwo) {
      return findLCA(one, two, lenOne - lenTwo);
    } else {
      return findLCA(two, one, lenTwo - lenOne);
    }
  }
  
  private int length(TreeNodeP node) {
    int length = 0;
    while (node != null) {
      length++;
      node = node.parent;
    }
    return length;
  }
  
  private TreeNodeP findLCA(TreeNodeP longer, TreeNodeP shorter, int diff) {
    while (diff != 0) {
      longer = longer.parent;
      diff--;
    }
    while (longer != shorter) {
      longer = longer.parent;
      shorter = shorter.parent;
    }
    return shorter;
  }
}

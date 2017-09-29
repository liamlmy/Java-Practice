// Given a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.
//
// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

/*
 * Method 1: BFS1 method
 */
/*
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (i == size - 1) {
                    result.add(cur.val);
                }
            }
        }
        return result;
    }
}
*/

/*
 * Method 2: DFS method
 */
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    rightView(root, result, 0);
    return result;
  }
    
  public void rightView(TreeNode curr, List<Integer> result, int currDepth){
    if(curr == null){
      return;
    }
    if(currDepth == result.size()){
      result.add(curr.val);
    }      
    rightView(curr.right, result, currDepth + 1);
    rightView(curr.left, result, currDepth + 1);    
  }
}

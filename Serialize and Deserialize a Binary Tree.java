// 请实现两个函数，分别用来序列化和反序列化二叉树

public class Solution {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
  }
    
    private void Serialize(TreeNode root, StringBuilder sb) {
        // Base case
        if (root == null) {
            sb.append("#,");
            return;
        }
        // Recursion rule
        sb.append(root.val);
        sb.append(",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }
    
    TreeNode Deserialize(String str) {
       if (str.length() == 0) {
           return null;
       }
        int[] index = new int[]{0};
        String[] array = str.split(",");
        return Deserialize(array, index);
  }
    
    private TreeNode Deserialize(String[] array, int[] index) {
        // Base case
		if (array[index[0]].equals("#")) {
			return null;
		}
		// Recursion rule
		TreeNode root = new TreeNode(Integer.parseInt(array[index[0]]));
		index[0]++;
		root.left = Deserialize(array, index);
        index[0]++;
		root.right = Deserialize(array, index);
		return root;
    }
}

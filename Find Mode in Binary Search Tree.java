// Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
// Assume a BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
//
// For example:
// Given BST [1,null,2,2],
//    1
//     \
//      2
//     /
//    2 
// return [2].
// Note: If a tree has more than one mode, you can return them in any order.
// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root==null)
            return new int[]{};
        traverse(root);
        ArrayList<Integer> list = new ArrayList<>();
        int maxValue=Integer.MIN_VALUE;
        for(Integer val : map.values()) {
            maxValue=Math.max(maxValue,val);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int key=entry.getKey();
            int value=entry.getValue();
            if(value==maxValue)
                list.add(key);
        }
        int[] new_arr=new int[list.size()];
        int index=0;
        for(Integer i:list) {
            new_arr[index++]=i;
        }
        return new_arr;
        
    }
    public void traverse(TreeNode root) {
        if(root==null)
            return;
        traverse(root.left);
        if(map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val)+1);
        }
        else
            map.put(root.val,1);
        traverse(root.right);
    }
}

class Solution {
    private int count = -1;
    private int lastVal = Integer.MAX_VALUE;
    private int maxCount = 0;
    private List<Integer> list = new LinkedList<Integer>();
 
    public int[] findMode(TreeNode root) {
        find(root);
        //check last part
        if (count > maxCount) {
            list.clear();
            list.add(lastVal);
        } else if (count == maxCount) {
            list.add(lastVal);
        }
 
        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }
 
    private void find(TreeNode root) {
        if (root == null) {
            return;
        }
        
        find(root.left);
        if (root.val != lastVal) {
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(lastVal);
            } else if (count == maxCount) {
                list.add(lastVal);
            }
            count = 1;
            lastVal = root.val;
        } else {
            count++;
        }
        find(root.right);
    }
}

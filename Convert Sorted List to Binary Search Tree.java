// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }
    
    private TreeNode toBST(ListNode head, ListNode tail) {
        // Base case
        if (head == tail) {
            return null;
        }
        // Recursion rule
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}

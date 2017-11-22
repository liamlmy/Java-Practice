// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode fast = pHead;
        ListNode slow = dummy;
        while (fast != null) {
            ListNode start = fast;
            int count = 0;
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
                count++;
            }
            fast = fast.next;
            count++;
            if (count == 1) {
                slow.next = start;
                slow = slow.next;
            }
        }
        slow.next = null;
        return dummy.next;
    }
}

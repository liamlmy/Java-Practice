public class Queue {
	private ListNode head;
	private ListNode tail;
  private int size;
	
	public Queue() {
		head = null;
    tail = null;
	}
  
  public void offer(int value) {
    ListNode node = new ListNode(value);
    if (size == 0) {
      tail = node;
      head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }
  
  public Integer peek() {
    if (size == 0) {
      return null;
    }
    return head.value;
  }
  
  public Integer poll() {
    if (size == 0) {
      return null;
    }
    ListNode prev = head;
    head = head.next;
    prev.next = null;
    size--;
    return prev.value;
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0 ? true : false;
  }
	
	static class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int value) {
			this.value = value;
		}
	}
}

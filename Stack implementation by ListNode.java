public class Stack {
  private ListNode head;
  private int size;
  
  public Stack() {
    head = null;
    size = 0;
  }

  public Stack(int value) {
		head = new ListNode(value);
		head.next = null;
		size = 1;
	}
  
  public void push(int value) {
    ListNode node = new ListNode(value);
    node.next = head;
    head = node;
    size++;
  }
  
  public Integer pop() {
    if (size == 0) {
      return null;
    }
    ListNode prev = head;
    head = head.next;
    prev.next = null;
    size--;
    return prev.value;
  }
  
  public Integer peek() {
    if (size == 0) {
      return null;
    }
    return head.value;
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

public class Queue {
	private int head;
	private int tail;
	private int size;
	private Integer[] array;
	
	public Queue() {
		head = 0;
		tail = 0;
		size = 0;
		array = new Integer[4];
	}
	
	public Queue(int capacity) {
		head = 0;
		tail = 0;
		size = 0;
		array = new Integer[capacity];
	}
	
	public void offer(int value) {
		if (size == array.length) {
			Integer[] newArray = new Integer[array.length * 2];
			for (int i = 0; i < size; i++) {
				if (head + i < array.length) {
					newArray[i] = array[head + i];
				} else {
					newArray[i] = array[head + i - array.length];
				}
			}
			head = 0;
			tail = array.length;
			array = newArray;
		}
		array[tail] = value;
		tail = tail + 1 == array.length ? 0 : tail + 1;
		size++;
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer result = array[head];
		head = head + 1 == array.length ? 0 : head + 1;
		size--;
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
}

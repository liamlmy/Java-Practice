public class Stack {
	private int head;
	private int size;
	private Integer[] array;
	
	public Stack() {
		head = 0;
		size = 0;
		array = new Integer[4];
	}
	
	public Stack(int capacity) {
		head = 0;
		size = 0;
		array = new Integer[capacity];
	}
	
	public void push(int value) {
		if (size == array.length) {
			Integer[] newArray = new Integer[array.length * 2];
			for (int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			head = size;
			array = newArray;
		}
		array[head] = value;
		head++;
		size++;
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head - 1];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer result = array[head - 1];
		head--;
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

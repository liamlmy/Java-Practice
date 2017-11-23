// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
// 并将P对1000000007取模的结果输出。 即输出P%1000000007
// 输入描述:
// 题目保证输入的数组中没有的相同的数字
// 数据范围：
// 	对于%50的数据,size<=10^4
// 	对于%75的数据,size<=10^5
// 	对于%100的数据,size<=2*10^5
// 示例
// 输入
// 1,2,3,4,5,6,7,0
// 输出
// 7

public class Solution {
	public int InversePairs(int [] array) {
		if (array == null || array.length <= 1) {
			return 0;
		}
		int[] helper = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			helper[i] = array[i];
		}
		return count(array, helper, 0, array.length - 1);
	}
	
	private int count(int[] array, int[] helper, int left, int right) {
		// Base case
		if (left >= right) {
			return 0;
		}
		// Recursion rule
		int mid = left + (right - left) / 2;
		int countLeft = count(array, helper, left, mid) % 1000000007;
		int countRight = count(array, helper, mid + 1, right) % 1000000007;
		int i = mid;
		int j = right;
		int index = right;
		int count = 0;
		while (i >= left && j > mid) {
			if (array[i] > array[j]) {
				count += j - mid;
				helper[index--] = array[i--];
				if (count >= 1000000007) {
					count = count % 1000000007;
				}
			} else {
				helper[index--] = array[j--];
			}
		}
		while (i >= left) {
			helper[index--] = array[i--];
		}
		while (j > mid) {
			helper[index--] = array[j--];
		}
		for (int k = left; k <= right; k++) {
			array[k] = helper[k];
		}
		return (countLeft + countRight + count) % 1000000007;
	}
}

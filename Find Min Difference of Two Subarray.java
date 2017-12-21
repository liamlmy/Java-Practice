// Given n numbers, X1,X2,...,Xn. If we separate these numbers into two groups, group A and group B.
// Every number belongs to A or B, not both. Suppose SA and SB denotes the sum of numbers within group A and group B.
// You are asked to find a separation such that make SA and SB be as close as possible.
// Your task is to write a program find the minimum difference: |SA − SB |.
// For example, 3 numbers X1 = 1,X2 = 2,X3 = 3. The answer should be X1,X2 ∈ A,X3 ∈B,sothatSA =SB. Sotheansweris0.

public class Solution {
	public int getMinDiff(int[] array) {
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
    // backpack problem
		int length = array.length;
		int[][] f = new int[length + 1][sum / 2 + 1];
		for (int i = 0; i < length; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				f[i + 1][j] = f[i][j];
				if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {
					f[i + 1][j] = f[i][j - array[i]] + array[i];
				}
			}
		}
		return sum - 2 * f[length][sum / 2];
	}
}

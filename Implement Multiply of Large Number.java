// 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。

public class Solution {
	public String multiply(String num1, String num2) {
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		int[] result = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				result[i + j] += a * b;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			int digit = result[i] % 10;
			int carry = result[i] / 10;
			sb.insert(0, digit);
			if (i + 1 < result.length) {
				result[i + 1] += carry;
			}
		}
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}

public class Split {
	public String[] split(String input, char ch) {
		// Corner check
		if (input == null || input.length() == 0) {
			return new String[]{input};
		}
		// Step 1: count how many substring will be remained after splitting
		int count = 1;
		int i = 0;
		while (i < input.length()) {
			if (input.charAt(i) == ch) {
				// Notice: ignore the adjacent target character
				while (i < input.length() && input.charAt(i) == ch) {
					i++;
				}
				count++;
			}
			i++;
		}
		if (input.charAt(0) == ch) {
			count--;
		}
		if (input.charAt(input.length() - 1) == ch) {
			count--;
		}
		// Step 2: splitting
		String[] result = new String[count];
		int index = 0;
		int cur = 0;
		while (cur < input.length()) {
			int start = cur;
			while (cur < input.length() && input.charAt(cur) != ch) {
				cur++;
			}
			if (start != cur) {						// Notice: ignore the adjacent target character
				result[index++] = input.substring(start, cur);
			}
			cur++;
		}
		return result;
	}
}

// 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。 
// 输入描述:
// 第一行包含两个整数n,m. 
// 第二行给出n个整数A1，A2，...，An。
//
// 数据范围
// 对于30%的数据，1 <= n, m <= 1000
// 对于100%的数据，1 <= n, m, Ai <= 10^5
//
// 输出描述:
// 输出仅包括一行，即所求的答案
//
// 输入例子1:
// 3 10  
// 6 5 10
//
// 输出例子1:
// 2

public class Main {

	private static class TrieTree {
		TrieTree[] next = new TrieTree[2];
		int count = 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scan.nextInt();
			}
			System.out.println(solve(array, m));
		}
	}

	private static long solve(int[] array, int m) {
		TrieTree trieTree = buildTrieTree(array);
		long result = 0;
		for (int i = 0; i < array.length; i++) {
			result += queryTrieTree(trieTree, array[i], m, 31);
		}
		return result / 2;
	}

	private static long queryTrieTree(TrieTree trieTree, int a, int m, int index) {
		if (trieTree == null) {
			return 0;
		}

		TrieTree current = trieTree;
		for (int i = index; i >= 0; i--) {
			int aDigit = (a >> i) & 1;
			int mDigit = (m >> i) & 1;
			if (aDigit == 1 && mDigit == 1) {
				if (current.next[0] == null) {
					return 0;
				}
				current = current.next[0];
			} else if (aDigit == 0 && mDigit == 1) {
				if (current.next[1] == null) {
					return 0;
				}
				current = current.next[1];
			} else if (aDigit == 1 && mDigit == 0) {
				long p = queryTrieTree(current.next[1], a, m, i - 1);
				long q = current.next[0] == null ? 0 : current.next[0].count;
				return p + q;
			} else if (aDigit == 0 && mDigit == 0) {
				long p = queryTrieTree(current.next[0], a, m, i - 1);
				long q = current.next[1] == null ? 0 : current.next[1].count;
				return p + q;
			}
		}
		return 0;
	}
	
	private static TrieTree buildTrieTree(int[] array) {
		TrieTree trieTree = new TrieTree();
		for (int i = 0; i < array.length; i++) {
			TrieTree current = trieTree;
			for (int j = 31; j >= 0; j--) {
				int digit = (array[i] >> j) & 1;
				if (current.next[digit] == null) {
					current.next[digit] = new TrieTree();
				} else {
					current.next[digit].count++;
				}
				current = current.next[digit];
			}
		}
		return trieTree;
	}
}

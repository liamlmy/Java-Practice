// 按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，数组的取值都为整数，函数在每个点都是严格单调递增或者严格递减
// 即A[i-1] != A[i] != A[i+1]，要求找出最宽的先上升后下降的区间
// 这个区间内函数的值必须先上升到一个点然后下降，区间的上升段和下降段长度必须都大于0。
// 1. 如果找到符合条件的最大区间输出数组对应的左右下标（保证只有一个最大区间）
// 2. 找不到那么输出-1 -1
// 输入格式
// n
// n长度的整数数组
// 输出格式
// 区间的范围
// 输入样例
// 10
// 1 3 1 2 5 4 3 1 9 10
// 输出样例
// 2 7
// 数据规模
// 对于 100% 的数据，1 <=n <=10, 000, 000

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
    }
    int max = Integer.MIN_VALUE;
    int[] result = new int[2];
    List<Integer> down = new ArrayList<>();
    if (x[0] < x[1]) {
      down.add(0);
    }
    for (int i = 1; i < n - 1; i++) {
      if (x[i] < x[i - 1] && x[i] < x[i + 1]) {
        down.add(i);
      }
    }
    if (x[n - 1] < x[n - 2]) {
      down.add(n - 1);
    }      
    for (int i = 1; i < down.size(); i++) {
      if (down.get(i) - down.get(i - 1) > max) {
        max = down.get(i) - down.get(i - 1);
        result[0] = down.get(i - 1);
        result[1] = down.get(i);
      }
    }
    System.out.println(result[0] + " " + result[1]);
  }
}

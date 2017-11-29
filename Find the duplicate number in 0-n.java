// 给一个数组，长度n，里面有n - 1以内整数，有重复的数字，在O(n)时间以及O(1)空间找出来。

public class Solution {
  public int duplicate(int[] number) {
    if (number == null || number.length <= 0) {
      return -1;
    }
    for (int num : number) {
      if (num < 0 || num >= number.length) {
        return -1;
      }
    }
    for (int i = 0; i < number.length; i++) {
      while (number[i] != i) {
        if (number[i] == number[number[i]]) {
          return number[i];
        }
        swap(number, i, number[i]);
      }
    }
    return -1;
  }
  
  private void swap(int[] number, int i, int j) {
    int temp = number[i];
    number[i] = number[j];
    number[j] = temp;
  }
}

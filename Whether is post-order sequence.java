// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

public class Solution {
  public boolean VerifySquenceOfBST(int [] sequence) {
    // Corner check
    if (sequence.length == 0) {
      return false;
    }
    // Recursion way
    return WhetherBST(sequence, 0, sequence.length - 1);
  }
  
  private boolean WhetherBST(int[] sequence, int start, int end) {
    // Base case
    if (start >= end) {
      return true;
    }
    // Recursion rule
    int rightStart = start;
    while (rightStart < end) {
      if (sequence[rightStart] > sequence[end]) {
        break;
      }
      rightStart++;
    }
    int rightEnd = rightStart;
    while (rightEnd < end) {
      if (sequence[rightEnd] < sequence[end]) {
        return false;
      }
      rightEnd++;
    }
    return WhetherBST(sequence, 0, rightStart - 1) && WhetherBST(sequence, rightStart, end - 1);
  }
}

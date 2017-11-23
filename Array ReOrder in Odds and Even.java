// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
// 偶数和偶数之间的相对位置不变。

public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (array[i] % 2 == 0) {
                j = i;
                while (j < array.length && array[j] % 2 == 0) {
                    j++;
                }
                if (j >= array.length) {
                    return;
                } else {
                    int odd = array[j];
                    move(array, i, j);
                    array[i] = odd;
                }
            }
            i++;
        }
    }
    
    private void move(int[] array, int start, int end) {
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
    }
}

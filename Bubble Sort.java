public class Solution {
  public void sort(int[] array) {
    if (array == null || array.length <= 1) {
      return;
    }
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j+ 1);
        }
      }
    }
  }
  
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

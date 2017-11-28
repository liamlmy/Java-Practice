// 六一儿童节，老师带了很多好吃的巧克力到幼儿园。
// 每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
// 老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。

public class Solution {
  public int findDancer(int[] chocolates, int[] kids) {
    Arrays.sort(chocolates);
    Arrays.sort(kids);
    int stuStart = 0;
    int count = 0;
    for (int i = 0; i < w.length; i++) {
      if (w[i] < h[stuStart]) {// 如果最小的巧克力比最小的学生要的小,那么跳出去下一个巧克力
        continue;
      } else {// 如果最小的巧克力比最小的学生要的大
        count++;// 那就把这个糖果给他,count加1
        stuStart++;// 给他后,把最小的学生加一个
        if (stuStart == kids.length) {// 如果最后一个学生都有糖了,就不找了,break掉
          break;
        }
      }
    }
    return count;
  }
}

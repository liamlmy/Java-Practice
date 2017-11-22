// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
// 输出描述:
// 对应每个测试案例，输出两个数，小的先输出。

public class Solution {
  public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>(new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                long pro1 = getPro(l1);
                long pro2 = getPro(l2);
                if (pro1 == pro2) {
                    return 0;
                }
                return pro1 < pro2 ? -1 : 1;
            }
        });
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] + array[j] == sum) {
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(array[j]);
                    cur.add(array[i]);
                    minHeap.offer(cur);
                }
            }
        }
        return minHeap.isEmpty() ? new ArrayList<Integer>() : minHeap.poll();
    }
    
    private long getPro(ArrayList<Integer> list) {
        long result = list.get(0) * list.get(1);
        return result;
    }
}

// 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
// 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
// 输出描述:
// 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
           return result;
        }
        int start = 1;
        int end = 2;
        while (start < (sum + 1) / 2) {
            int curSum = getCurSum(start, end);
            if (curSum == sum) {
                ArrayList<Integer> cur = getCur(start, end);
                result.add(cur);
                start++;
                end++;
            } else if (curSum < sum) {
                end++;
            } else {
                start++;
            }
        }
        return result;
    }
    
    private int getCurSum(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }
    
    private ArrayList<Integer> getCur(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        while (start <= end) {
            result.add(start);
            start++;
        }
        return result;
    }
}

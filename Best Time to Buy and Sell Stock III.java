// Say you have an array for which the ith element is the price of a given stock on day i.
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;
        for (int i : prices) {
            release2 = Math.max(release2, hold2 + i);
            hold2 = Math.max(hold2, release1 - i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, -i);
        }
        return release2;
    }
}

// 给定一个误差范围和一个数，求出它的平方根

public class Solution {
  public double sqrt(double num, double error) {
		return sqrt(0.0, num, num, error);
	}
	
	private double sqrt(double left, double right, double num, double error) {
		double mid = left + (right - left) / 2;
		double target = mid * mid;
		if (Math.abs(target - num) < error) {
			return mid;
		} else if (target > num) {
			return sqrt(left, mid, num, error);
		} else {
			return sqrt(mid, right, num, error);
		}
	}
}

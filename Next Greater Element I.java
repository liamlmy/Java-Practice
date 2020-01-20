// You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
// The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//
// Example 1:
// Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
// Output: [-1,3,-1]
// Explanation:
//     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//     For number 1 in the first array, the next greater number for it in the second array is 3.
//     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
// Example 2:
// Input: nums1 = [2,4], nums2 = [1,2,3,4].
// Output: [3,-1]
// Explanation:
//     For number 2 in the first array, the next greater number for it in the second array is 3.
//     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
// Note:
// All elements in nums1 and nums2 are unique.
// The length of both nums1 and nums2 would not exceed 1000.

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int [] result = new int[findNums.length];
        int z=0;
        for(int i=0;i<findNums.length; i++){
            int index = SearchIndex(findNums[i],nums);
            //向右遍历 ，找到next greater
            for(int j=index;j<nums.length;j++) {
                if(nums[j] > findNums[i]) {
                    result[z]= nums[j];
                    break;
                } else {
                    result[z] = -1;
                }
            }
            z++;
        }
        return result;
    }
    //用来找到位置
    public static int SearchIndex(int numElement,int[] nums) {
	      int index=0;
	      for(int i=0;i<nums.length;i++) {
		        if(nums[i] == numElement) {
			          index = i;
		        }
	      }
	      return index;
	  }
}

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int Length = nums.length;
        int findLength = findNums.length;
        int[] Final = new int[findLength];
        int max = nums[0];
        //找到nums中最大的值
        for (int i = 1; i < Length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] Indexer = new int[max + 1];
        for (int i = 0; i < Length; i++) {
        //通过一个新的数组，将原数组的值作为索引，原数组的索引作为值，
        //这样可以很方便的找到指定数组元素的下标，只需要一次循环即可，而我写的findNums
        //中有多少元素，就需要多少次循环，效率很低。 这里需要学习
            Indexer[nums[i]] = i;
        }
        boolean Found = false;
        int cur, curindex;
        for (int i = 0; i < findLength; i++) {
            Found = false;
            cur = findNums[i];
            //找到需要遍历的索引值
            curindex = Indexer[cur] + 1;
            //初始化为-1
            Final[i] = -1;
            //判断当前值是否是最大值，如果是最大值，就不用找了，而我写的没有此类判断，效率低下
            if (cur != max) {
                //如果已经找到大于cur的值，就不用再找了，用Found进行控制
                while (curindex < Length && Found != true) {
                    if (nums[curindex] > cur) {
                        Found = true;
                        Final[i] = nums[curindex];
                    }
                    curindex++;
                }
            }
        }
        return Final;
    }
}

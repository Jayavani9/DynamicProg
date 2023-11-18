740. Delete and Earn


You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.


class Solution {
    //Tc: O(n) + O(max(n))  Sc: O(n)
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i:nums)
        {
            max = Math.max(i,max);
        }

        int arr[] = new int[max+1];
        for(int i:nums)
        {
            arr[i] += i;
        }

        int prev = arr[0];
        int curr = Math.max(prev,arr[1]);
        for(int j = 2; j < arr.length; j++)
        {
            int temp = curr;
            curr = Math.max(arr[j]+ prev, curr);
            prev = temp;
        }

        return curr; 
    }
}

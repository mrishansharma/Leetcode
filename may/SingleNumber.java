/*
* Single Number
* Given a non-empty array of integers, every element appears twice except for one. Find that single one.
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* Example 1:
* Input: [2,2,1]
* Output: 1
* Example 2:

* Input: [4,1,2,1,2]
* Output: 4
* xor of a number with itself is 0 
* xor of x^y^x = 0^y = y
* we do xor of all elements in the array so the odd number is left out 
* memory complexity = o(1) 
*/
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i=0;i<nums.length;i++)
        {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
/*
*Number Complement
*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
*Example 1:
*Input: 5
*Output: 2
*Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
*Example 2:
*Input: 1
*Output: 0
*Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to outpu
*/
class Solution {
    public int findComplement(int num) {
        int arr[] = new int[32];
        int arr_index = 0;
        while(num>0)
        {
            arr[arr_index]= num%2;
            arr_index++;
            num=num/2;
        }
        int multiple_2 = 1;
        int ans = 0;
        int flip =0;
        for(int i=0;i<arr_index;i++)
        {
            if(arr[i]==0) flip=1;
            else flip=0;
            ans = ans + flip*multiple_2;
            multiple_2 = multiple_2 *2;
        }
        return ans;
    }
}
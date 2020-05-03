/*
JewelsAndStones
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        char j[] = J.toCharArray();
        char s[] = S.toCharArray();
        int exist[] = new int[52];   
        for (int i=0;i<j.length;i++)
        {
            //System.out.println(j[i]);
            //System.out.println(j[i]-'A');
            int index = j[i]-'A';
            if(index>26)index=index-6;
            exist[index] = 1;
        }
        int ans=0;
        for(int i=0;i<s.length;i++)
        {
            int index = s[i]-'A';
            if(index>26)index=index-6;
            if(exist[index]==1)ans++;
        }
        return ans;
    }
}
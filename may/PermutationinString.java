/*Permutation in String
* 
* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
* Example 1:
* 
* Input: s1 = "ab" s2 = "eidbaooo"
* Output: True
* Explanation: s2 contains one permutation of s1 ("ba").
* 
* Example 2:
* 
* Input:s1= "ab" s2 = "eidboaoo"
* Output: False
* 
*   
* 
* Note:
* 
*     The input strings only contain lower case letters.
*     The length of both given strings is in range [1, 10,000].
* 
/* 
class Solution {
    int[] hash(char[] ch,int start,int end)
    {
        int ans[] = new int[26];
        for(int i=start;i<=end;i++)
        {
            ans[ch[i]-'a']++;
        }
        return ans;
    }
    boolean compare(int[] ch1, int[] ch2)
    {
        boolean ans = true;
        for(int i=0;i<ch1.length;i++)
        {
            if(ch1[i]!=ch2[i])return false;
        }
        return ans;
    }
    public boolean checkInclusion(String s1, String s2) {
        char[] arrs1 = s1.toCharArray();
        char[] arrs2 = s2.toCharArray();
        if(arrs1.length>arrs2.length || arrs1.length == 0 ||arrs2.length==0)return false;
        int[] hashs1 = hash(arrs1,0,arrs1.length-1);
        int[] hashs2 = hash(arrs2,0,arrs1.length-1);
        boolean ans = compare(hashs1,hashs2);
        if(ans)return ans;
        for(int start=1,end = arrs1.length;!ans&&end<arrs2.length;start++,end++)
        {
            hashs2[arrs2[start-1]-'a']--;
            hashs2[arrs2[end]-'a']++;
            ans = compare(hashs1,hashs2);
        }
        return ans;
    }
}
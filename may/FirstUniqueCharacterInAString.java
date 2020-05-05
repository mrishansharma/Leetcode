/*
*First Unique Character in a String
*
*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*Examples:
*s = "leetcode"
*return 0.
*s = "loveleetcode",
*return 2.
*Note: You may assume the string contain only lowercase letters.
*
*/
class Solution {
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int count[] = new int[26];
        for(int i=0;i<array.length;i++)
        {
            count[array[i]-'a']++;
        }
        int answer = -1;
        for(int i=0;i<array.length;i++)
        {
            if(count[array[i]-'a']==1)
            {
                answer = i;
                break;
            }    
        }
        return answer;
    }
}
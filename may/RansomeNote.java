/*
RANSOM NOTE 

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char ransomNote_char[] = ransomNote.toCharArray();
        char magazine_char[] = magazine.toCharArray();
        int ransomNote_count[] = new int[26];
        int magazine_count[] = new int[26];
        for(int i=0;i<ransomNote_char.length;i++){
            ransomNote_count[ransomNote_char[i]-'a']++;
        }
        for(int i=0;i<magazine_char.length;i++){
            magazine_count[magazine_char[i]-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(magazine_count[i]<ransomNote_count[i])return false;
        }
        return true;
    }
}
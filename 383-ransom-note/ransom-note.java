class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        if(ransomNote.length() > magazine.length()) 
        return false;

        int[] charMap = new int[26];
        for(char ch : magazine.toCharArray())
        charMap[ch - 'a']++;

        for(char ch : ransomNote.toCharArray())
        {
            if(charMap[ch - 'a'] == 0)
            return false;

            charMap[ch - 'a']--;
        }

        return true;
    }
}
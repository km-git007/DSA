class Solution {
public:
    int longestPalindrome(string s) 
    {
        unordered_map<char,int> map;
        for(char ch : s)
        map[ch]++;

        int hasOddFreq = false;
        int length = 0;
        for(auto ele : map)
        {
            if(ele.second % 2 == 0)
            length += ele.second;

            else
            {
                hasOddFreq = true;
                length += ele.second - 1;
            }
        }
        
        return hasOddFreq == true ? length + 1 : length;
    }
};
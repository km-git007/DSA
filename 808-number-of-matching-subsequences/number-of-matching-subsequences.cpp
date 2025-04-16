class Solution {
public:
    bool isSubsequence(string &s, const string &word)
    {
        int i = 0, j = 0;
        while(i < s.length() && j < word.length())
        {
            if(s[i] == word[j])
            j++;
            i++;
        }
        return j == word.length();
    }

    int numMatchingSubseq(string s, vector<string>& words) 
    {
        unordered_map<string, int> map;
        for(string word : words)
        map[word]++;

        int count = 0;
        for(auto& [word, wordFrequency] : map)
        {
            if(isSubsequence(s, word))
            count += wordFrequency;
        }
        return count;
    }
};
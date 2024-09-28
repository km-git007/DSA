class Solution {
public:
    bool reportSpam(vector<string>& message, vector<string>& bannedWords) 
    {
        unordered_set<string> set(bannedWords.begin(),bannedWords.end());
        int count=0;
        for(string word : message)
        {
            if(set.count(word))
            count++;

            if(count==2)
            return true;
        }
        return false;
    }
};
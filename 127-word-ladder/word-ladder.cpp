class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) 
    {
        unordered_set<string> set;
        for(string s : wordList)
        set.insert(s);

        queue<pair<string,int>> q;
        q.push({beginWord,1});
        set.erase(beginWord);

        while(!q.empty())
        {
            auto p = q.front();
            q.pop();

            string word = p.first;
            if(word == endWord)
            return p.second;

            for(int i = 0; i < word.length(); i++)
            {
                char originalChar = word[i];
                for(char c = 'a'; c <= 'z'; c++)
                {
                    word[i] = c;
                    if(set.count(word) > 0)
                    {
                        set.erase(word);
                        q.push({word, p.second + 1});
                    }
                }
                word[i] = originalChar;
            }
        }
        return 0;
    }
};
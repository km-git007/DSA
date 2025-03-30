class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) 
    {
        unordered_set<string> set;
        for(string s : wordList)
        set.insert(s);

        queue<string> q;
        q.push(beginWord);
        set.erase(beginWord);

        int steps = 0;
        while(!q.empty())
        {
            int level = q.size();
            while(level--)
            {
                string word = q.front();
                q.pop();

                if(word == endWord)
                return steps + 1;

                for(int i = 0; i < word.length(); i++)
                {
                    char originalChar = word[i];
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        word[i] = c;
                        if(set.count(word) > 0)
                        {
                            set.erase(word);
                            q.push(word);
                        }
                    }
                    word[i] = originalChar;
                }
            }
            steps++;
        }
        return 0;
    }
};
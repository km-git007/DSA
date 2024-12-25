class Solution {
public:
    int openLock(vector<string>& deadEnds, string target) 
    {
        // Map the next slot digit for each current slot digit.
        unordered_map<char, char> nextSlot = {
            {'0', '1'}, 
            {'1', '2'}, 
            {'2', '3'}, 
            {'3', '4'}, 
            {'4', '5'},
            {'5', '6'}, 
            {'6', '7'}, 
            {'7', '8'}, 
            {'8', '9'}, 
            {'9', '0'}
        };
        // Map the previous slot digit for each current slot digit.
        unordered_map<char, char> prevSlot = {
            {'0', '9'}, 
            {'1', '0'}, 
            {'2', '1'}, 
            {'3', '2'}, 
            {'4', '3'},
            {'5', '4'}, 
            {'6', '5'}, 
            {'7', '6'}, 
            {'8', '7'}, 
            {'9', '8'}
        };

        unordered_set<string> set;
        for(string s : deadEnds)
        set.insert(s);

        if(set.count("0000"))
        return -1;

        queue<string> q;
        q.push("0000");

        int turns = 0;
        while(!q.empty())
        {
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++)
            {
                string currString = q.front();
                q.pop();

                if(currString == target)
                return turns;

                for(int j = 0; j < 4; j++)
                {
                    string str = currString;
                    str[j] = nextSlot[str[j]];
                    if(set.count(str) == 0)
                    {
                        set.insert(str);
                        q.push(str);
                    }

                    str = currString;
                    str[j] = prevSlot[str[j]];
                    if(set.count(str) == 0)
                    {
                        set.insert(str);
                        q.push(str);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
};
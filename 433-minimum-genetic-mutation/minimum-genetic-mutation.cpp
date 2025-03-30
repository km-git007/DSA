class Solution {
public:
    int minMutation(string startGene, string target, vector<string>& bank) 
    {
        unordered_set<string> set(bank.begin(), bank.end());

        // can't go to the target if its not in the bank
        if(!set.count(target))
        return -1;

        queue<string> q;
        q.push(startGene);

        int steps = 0;
        vector<char> mutations = {'A', 'C', 'G', 'T'};
        while(!q.empty())
        {
            int level = q.size();
            while(level--)
            {
                string curr = q.front();
                q.pop();

                if(curr == target)
                return steps;

                for(int i = 0; i < curr.length(); i++)
                {
                    char originalChar = curr[i];
                    for(char ch : mutations)
                    {
                        curr[i] = ch;
                        if(set.count(curr))
                        {
                            q.push(curr);
                            set.erase(curr);
                        }
                    }
                    curr[i] = originalChar;
                }
            }
            steps++;
        }
        return -1;
    }
};
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
                string currGene = q.front();
                q.pop();

                if(currGene == target)
                return steps;

                for(int i = 0; i < currGene.length(); i++)
                {
                    int org = currGene[i];
                    for(char ch = 'A'; ch <= 'Z'; ch++)
                    {
                        if(ch == org)
                        continue;

                        // change the character
                        currGene[i] = ch;

                        // check whether this mutataed gene exists in the bank
                        if(set.count(currGene))
                        {
                            q.push(currGene);
                            set.erase(currGene);
                        }
                    }
                    // change the character at this index back to original
                    currGene[i] = org;
                }
            }
            steps++;
        }
        return -1;
    }
};
class Solution {
public:
    int minOperations(vector<string>& logs) 
    {
        int folderDepth=0;
        for(const string& s : logs)
        {
            if(s=="../")
            {
                if(folderDepth!=0)
                folderDepth--;
            }

            else if(s=="./")
            continue;

            else
            folderDepth++;
        }
        return folderDepth;
    }
};
class Solution {
public:
    int findLongestChain(vector<vector<int>>& meetings) 
    {
        // sort on the basis of end time of the meetings
        // the simple logic is the that the meetings that finish earliest should be completed first so that
        // more number of meetings can be conducted in the 
        sort(meetings.begin(), meetings.end(), [](std::vector<int>& a, std::vector<int>& b) {
            return a[1] < b[1];
        });

        int meets=1;
        int prev=0;
        for(int i=0;i<meetings.size();i++)
        {
            if(meetings[prev][1]<meetings[i][0])
            {
                meets++;
                prev=i;
            }
        }
        return meets;
    }
};
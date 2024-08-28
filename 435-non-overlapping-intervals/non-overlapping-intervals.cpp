class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) 
    {
        // we will find the max size chain of non overlapping intervals
        // n meets in one room

        // sort on the basis of end time of the meetings
        // the simple logic is the that the meetings that finish earliest should be completed first so that
        // more number of meetings can be conducted in the 
        sort(intervals.begin(), intervals.end(), [](std::vector<int>& a, std::vector<int>& b) {
            return a[1] < b[1];
        });

        int meets=1;
        int prev=0;
        for(int i=0;i<intervals.size();i++)
        {
            // if there is no overlapping
            if(intervals[prev][1]<=intervals[i][0])
            {
                meets++;
                prev=i;
            }
        }
        return intervals.size()-meets;
    }
};
class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) 
    {
        vector<string> ans;
        if(nums.size()==0)
        return ans;
        int j=0;
        while(j<nums.size())
        {
            int start=j;
            int end=j+1;
            while(end<nums.size() && (nums[end]==nums[end-1]+1))   //nums=[-2147483648,-2147483647,2147483647];
            end++;

            if(end-start>1)
            ans.push_back(to_string(nums[start])+"->"+to_string(nums[end-1]));
            else
            ans.push_back(to_string(nums[start]));

            j=end;
        }
        return ans;
    }
};
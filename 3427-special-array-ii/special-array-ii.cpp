class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) 
    {
        int n = nums.size();
        vector<int> count(n, 0);
        for(int i = 1; i < nums.size(); i++)
        {
            count[i] = count[i - 1];

            if(nums[i] % 2 == nums[i - 1] % 2)
            count[i]++;
        }

        vector<bool> res;
        for(auto query : queries)
        {
            int start = query[0];
            int end = query[1];
            res.push_back(count[end] - count[start] == 0);
        }
        return res;
    }
};
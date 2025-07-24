class Solution {
public:
    vector<int> resultsArray(vector<int>& nums, int k) 
    {
        int n = nums.size();
        if(n == 1 || k == 1)
        return nums;

        vector<int> res(n - k + 1);
        int count = 1, i = 0;
        for(int j = 1; j < n; j++)
        {
            if(nums[j] == nums[j - 1] + 1)
            count++;
            else
            count = 1;

            if(j >= k - 1)
            {
                if(count >= k)
                res[i++] = nums[j];

                else
                res[i++] = -1;
            }
        }
        return res;
    }
};
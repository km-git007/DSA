class Solution {
public:
    vector<int> getSneakyNumbers(vector<int>& nums) 
    {
        vector<int> ans;
        unordered_set<int> set;
        for(int num : nums)
        {
            if(set.count(num)>0)
            ans.push_back(num);

            set.insert(num);
        }
        return ans;
    }
};
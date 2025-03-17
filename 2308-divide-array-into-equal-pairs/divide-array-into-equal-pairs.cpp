class Solution {
public:
    bool divideArray(vector<int>& nums) 
    {
        unordered_set<int> set;
        for(int num : nums)
        {
            if(set.count(num))
            set.erase(num);

            else
            set.insert(num);
        }

        return set.empty();
    }
};
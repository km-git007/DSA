class Solution {
public:
    int minimumOperations(vector<int>& nums) 
    {
        unordered_map<int, int> map;
        for(int num : nums)
        map[num]++;

        int j = nums.size() - 1;
        int i = 0, opr = 0;
        while(j - i + 1 >= 3)
        {
            if(map.size() == j - i + 1)
            return opr;

            for(int k = i; k < i + 3; k++)
            {
                map[nums[k]]--;
                if(map[nums[k]] == 0)
                map.erase(nums[k]);
            }

            i += 3;
            opr++;
        }

        return j - i + 1 > map.size() ? opr + 1 : opr;
    }
};
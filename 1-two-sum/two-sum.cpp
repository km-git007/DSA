class Solution {
public:
    vector<int> twoSum(vector<int>& a, int target) 
    {
        unordered_map<int,int> map;
        for(int i=0;i<a.size();i++)
        {
            if(map.find(target-a[i])!=map.end())
            return {map[target-a[i]], i};

            map.insert({a[i],i});
        }
        return {};
    }
};
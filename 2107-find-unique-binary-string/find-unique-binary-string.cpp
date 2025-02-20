class Solution {
public:
    unordered_set<string> set;
    string res;
    bool solve(int n)
    {
        if(n > set.size())
        return !set.count(res);

        res.push_back('0');
        bool take0 = solve(n + 1);
        if(take0)
        return true;
        res.pop_back();

        res.push_back('1');
        bool take1 = solve(n + 1);
        if(take1)
        return true;
        res.pop_back();

        return false;
    }

    string findDifferentBinaryString(vector<string>& nums) 
    {
        for(string num : nums)
        set.insert(num);

        res = "";
        solve(1);

        return res;
    }
};
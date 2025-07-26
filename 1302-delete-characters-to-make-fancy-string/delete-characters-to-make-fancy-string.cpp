class Solution {
public:
    string makeFancyString(string s) 
    {
        string res = "";
        for(char ch : s)
        {
            if(res.size() >= 2 && ch == res.back() && ch == res[res.size() - 2])
            res.pop_back();

            res.push_back(ch);
        }
        return res;
    }
};
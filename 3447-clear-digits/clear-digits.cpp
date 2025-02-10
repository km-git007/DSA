class Solution {
public:
    string clearDigits(string s) 
    {
        string res = "";
        for(char ch : s)
        {
            if(isdigit(ch))
            {
                if(!res.empty())
                res.pop_back();
            }

            else
            res.push_back(ch);
        }

        return res;
    }
};
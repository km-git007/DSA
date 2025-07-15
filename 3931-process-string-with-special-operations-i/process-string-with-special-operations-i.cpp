class Solution {
public:
    string duplicate(string &s)
    {
        string res = s;
        for(char ch : s)
        res.push_back(ch);

        return res;
    }

    void reverse(string &s)
    {
        int left = 0, right = s.length() - 1;
        while(left < right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    string processStr(string s) 
    {
        string res = "";

        for (char ch : s) 
        {
            if (ch >= 'a' && ch <= 'z') {
                res.push_back(ch);
            }
            else if (ch == '*') {
                if (!res.empty())
                    res.pop_back();
            }
            else if (ch == '#') {
                if (!res.empty())
                    res = duplicate(res);
            }
            else if (ch == '%') {
                if (!res.empty())
                    reverse(res);
            }
        }
        return res;
    }
};
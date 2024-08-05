class Solution {
public:
    string removeOuterParentheses(string s) 
    {
        string ans="";
        int depth=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='(')
            depth++;
            else
            depth--;

            if(depth==0 || (depth==1 && s[i]=='('))
            continue;
            ans.push_back(s[i]);
        }
        return ans;
    }
};
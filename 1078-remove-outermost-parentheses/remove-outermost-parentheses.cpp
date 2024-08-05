class Solution {
public:
    string removeOuterParentheses(string s) 
    {
        string ans="";
        stack<char> stack;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='(')
            stack.push(s[i]);
            else
            stack.pop();

            if(stack.empty() || (stack.size()==1 && s[i]=='('))
            continue;
            ans.push_back(s[i]);
        }
        return ans;
    }
};
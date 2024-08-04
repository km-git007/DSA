class Solution {
public:
    int maxDepth(string s) 
    {
        int maxDepth=0;
        vector<int> stack;
        for(char c : s)
        {
            if(c=='(')
            stack.push_back(c);
            else if(c==')')
            stack.pop_back();

            maxDepth=max((int)stack.size(),maxDepth);
        }
        return maxDepth;
    }
};
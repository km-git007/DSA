class Solution {
public:
    int maxDepth(string str) 
    {
        int maxDepth=0;
        stack<int> s;
        for(char c : str)
        {
            if(c=='(')
            s.push(c);
            else if(c==')')
            s.pop();

            maxDepth=max((int)s.size(),maxDepth);
        }
        return maxDepth;
    }
};
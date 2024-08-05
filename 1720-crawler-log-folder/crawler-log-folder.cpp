class Solution {
public:
    int minOperations(vector<string>& logs) 
    {
        stack<string> stack;
        for(const string& s : logs)
        {
            if(s=="../")
            {
                if(!stack.empty())
                stack.pop();
            }

            else if(s=="./")
            continue;

            else
            stack.push(s);
        }
        return (int)stack.size();
    }
};
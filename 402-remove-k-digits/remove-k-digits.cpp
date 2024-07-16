class Solution {
public:
    string removeKdigits(string num, int k) 
    {
        if(k==num.length())
        return "0";

        stack<char> stack;
        for(int i=0;i<num.length();i++)
        {
            while(!stack.empty() && num[i]<stack.top() && k>0)
            {
                stack.pop();
                k--;
            }

            if(num[i]!='0' || !stack.empty())
            stack.push(num[i]);
        }

        while(!stack.empty() && k--)      // for num=[1,2,3,4,5,6] k=3;
        stack.pop();

        string ans="";
        while(!stack.empty())
        {
            ans.push_back(stack.top());
            stack.pop();
        }

        reverse(ans.begin(),ans.end());
        return (ans=="")?"0":ans;
    }
};
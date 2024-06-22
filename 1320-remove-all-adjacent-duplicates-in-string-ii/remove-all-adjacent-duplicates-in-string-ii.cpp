class Solution {
public:
    string removeDuplicates(string s, int k) 
    {
        stack<pair<char,int>> stack;
        stack.push({s[0],1});
        for(int i=1;i<s.length();i++)
        {
            if(!stack.empty() && s[i]==stack.top().first)
            stack.top().second++;
            else
            stack.push({s[i],1});

            while(!stack.empty() && stack.top().second==k)
            stack.pop();
        }

        string ans="";
        while(!stack.empty())
        {
            char c=stack.top().first;
            int freq=stack.top().second;
            stack.pop();

            while(freq--)
            ans.push_back(c);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};
class Solution {
public:
    string simplifyPath(string path) 
    {
        stringstream ss(path);
        string token;
        char delimiter = '/';

        stack<string> st;
        while(getline(ss, token, delimiter))
        {
            if(token == "" || token == ".")
            continue;

            if(token == "..")
            {
                if(!st.empty())
                st.pop();
            }
            else
            st.push(token); 
        }

        // If stack is empty, the simplified path is "/"
        if (st.empty()) 
            return "/";

        // Rebuild the simplified path from the stack
        string res = "";
        while (!st.empty()) 
        {
            res = "/" + st.top() + res; // Add "/" before each directory name
            st.pop();
        }

        return res;
    }
};
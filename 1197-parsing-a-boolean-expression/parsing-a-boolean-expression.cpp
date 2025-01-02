class Solution {
public:
    bool solve(vector<char> &temp, char opr)
    {
        if(opr == '|')
        {
            for(char c : temp)
            if(c == 't')
            return true;

            return false;
        }

        for(char c : temp)
        if(c == 'f')
        return false;

        return true;
    }

    bool parseBoolExpr(string exp) 
    {
        stack<char> s;
        for(char c : exp)
        {
            if(c != ')')
            s.push(c);
            else
            {
                vector<char> temp;
                while(s.top() != '(')
                {
                    if(s.top() != ',')
                    temp.push_back(s.top());
                    s.pop();
                }

                s.pop();
                char operation = s.top();
                s.pop();

                if(operation == '&' || operation == '|')
                s.push(solve(temp, operation) ? 't' : 'f');
                else
                s.push(temp[0] == 'f' ? 't' : 'f');
            }
        }
        return s.top() == 'f' ? false : true;
    }
};
class Solution {
public:
    int scoreOfParentheses(string s) 
    {
        stack<int> stack;
        stack.push(-1);
        for(int i = 1; i < s.length(); i++)
        {
            if(s[i] == '(')
            stack.push(-1);
            else
            {
                if(stack.top() < 0)
                {
                    stack.pop();
                    stack.push(1);
                    continue;
                }
                
                int score = 0;
                while(!stack.empty() && stack.top() > 0)
                {
                    score += stack.top(); 
                    stack.pop();
                }

                // pop '(' from the stack
                stack.pop();

                //push the score after doubling it
                stack.push(2 * score);
            }
        }

        int total = 0;
        while(!stack.empty())
        {
            total += stack.top();
            stack.pop();
        }

        return total;
    }
};
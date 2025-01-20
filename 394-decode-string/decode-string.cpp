class Solution {
public:
    string decodeString(string s) 
    {
        stack<int> numStack;
        stack<string> stringStack;
        int index = 0;
        while(index < s.length())
        {
            // If it's a number, parse the full number
            if (isdigit(s[index])) 
            {
                int num = 0;
                while (index < s.length() && isdigit(s[index])) 
                {
                    num = num * 10 + (s[index] - '0');
                    index++;
                }
                numStack.push(num);
            }
            // If it's a letter or '[', push it onto the string stack
            else if (isalpha(s[index]) || s[index] == '[') 
            {
                stringStack.push(string(1, s[index]));
                index++;
            }
            // If it's ']', process the encoded string
            else 
            {
                string curr = "";
                // Build the current substring until we find '['
                while (stringStack.top() != "[") 
                {
                    curr = stringStack.top() + curr;
                    stringStack.pop();
                }

                // Pop the '['
                stringStack.pop();

                // Get the repetition count from the number stack
                int timesToRepeat = numStack.top();
                numStack.pop();

                // Repeat the current substring and push it back onto the stack
                string repeatedString = "";
                while(timesToRepeat--) 
                repeatedString += curr;
                
                stringStack.push(repeatedString);
                index++;
            }
        }

        // Build the final result from the stack
        string res = "";
        while (!stringStack.empty()) 
        {
            res = stringStack.top() + res;
            stringStack.pop();
        }
        return res;
    }
};
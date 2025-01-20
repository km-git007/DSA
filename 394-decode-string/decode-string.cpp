class Solution {
public:
    int helper(int &i, string &s)
    {
        int num = 0;
        while(i < s.length() && s[i] >= '0' && s[i] <= '9')
        {
            num = num * 10 + (s[i] - '0');
            i++;
        }
        return num;
    }

    string decodeString(string s) 
    {
        stack<int> numStack;
        stack<string> stringStack;
        int index = 0;
        while(index < s.length())
        {
            // a number
            if(s[index] >= '1' && s[index] <= '9')
            {
                int num = helper(index, s);
                numStack.push(num);
            }
            
            // lowercase English letter - {a, z} or '['
            else if((s[index] >= 'a' && s[index] <= 'z') || s[index] == '[')
            {
                stringStack.push(string(1, s[index]));
                index++;
            }

            // ']'
            else
            {
                // build the string
                string curr = "";
                while(stringStack.top() != "[")
                {
                    curr = stringStack.top() + curr;
                    stringStack.pop();
                }

                // pop '['
                stringStack.pop();

                int timesToRepeat = numStack.top();
                numStack.pop();

                // create the repeatedString string by repeating it 'timesToRepeat' times
                string repeatedString = "";
                while(timesToRepeat--)
                repeatedString += curr;

                // push the generated string into the strStack
                stringStack.push(repeatedString);
                index ++;
            }
        }

        string res = "";
        while(!stringStack.empty())
        {
            res = stringStack.top() + res;
            stringStack.pop();
        }
        return res;
    }
};
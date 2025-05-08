class Solution {
public:
    string findDivisor(int num)
    {
        if(num % 3 == 0 && num % 5 == 0)
        return "FizzBuzz";

        else if(num % 3 == 0)
        return "Fizz";

        else if(num % 5 == 0)
        return "Buzz";

        return to_string(num);
    }

    vector<string> fizzBuzz(int n) 
    {
        vector<string> res(n);
        for(int i = 0; i < n; i++)
        {
            string str = findDivisor(i + 1);
            res[i] = str;
        }
        return res;
    }
};
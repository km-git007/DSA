class Solution {
public:
    int splitNum(int num) 
    {
        // Step 1: Extract digits and sort them
        vector<int> digits;
        while (num > 0) 
        {
            digits.push_back(num % 10);
            num /= 10;
        }
        sort(digits.begin(), digits.end());

        // Step 2: Distribute digits into num1 and num2
        int num1 = 0, num2 = 0;
        for (int i = 0; i < digits.size(); i++) 
        {
            if(i % 2 == 0) 
            num1 = num1 * 10 + digits[i];

            else
            num2 = num2 * 10 + digits[i];
        }

        // Step 3: Return the sum
        return num1 + num2;
    }
};
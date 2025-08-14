class Solution {
public:
    string largestGoodInteger(string num) 
    {
        int count = 1, maxNum = -1;
        for(int i = 1; i < num.length(); i++)
        {
            if(num[i] == num[i - 1])
            count++;
            else
            count = 1;

            if(count == 3)
            maxNum = max(maxNum, stoi(num.substr(i - 2, 3)));
        }

        if(maxNum == 0)
        return "000";
        
        return maxNum == -1 ? "" : to_string(maxNum);
    }
};
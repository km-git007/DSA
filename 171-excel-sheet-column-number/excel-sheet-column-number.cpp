class Solution {
public:
    int titleToNumber(string columnTitle) 
    {
        long long res = 0, mul = 1; // Use long long for larger values
        int index = columnTitle.length() - 1;
        while(index >= 0) 
        {
            res += mul * (columnTitle[index--] - 'A' + 1);
            mul *= 26; // Update multiplier
        }
        return res; 
    }
};
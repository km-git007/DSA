class Solution {
public:
    string convertToTitle(int columnNumber) 
    {
        string res = "";
        while (columnNumber > 0) 
        {
            columnNumber--; // Decrement columnNumber to handle 1-based indexing
            res.push_back('A' + (columnNumber % 26)); // Map remainder to corresponding character
            columnNumber /= 26; // Move to the next "digit"
        }
        reverse(res.begin(), res.end()); // Reverse the result to get the correct order
        return res;
    }
};
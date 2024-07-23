class Solution {
public:
    vector<string> keypad;
    vector<string> res;
    string curr;
    void helper(string &digits,int index)
    {
        if(index==digits.length())
        {
            res.push_back(curr);
            return;
        }

        int number=digits[index]-'0';
        string str=keypad[number];
        for(int i=0;i<str.length();i++)
        {
            curr+=str[i];
            helper(digits,index+1);
            curr.pop_back();
        }
    }
    
    vector<string> letterCombinations(string digits) 
    {
        if(digits.length()==0)
        return res;

        keypad={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        curr="";
        helper(digits,0);

        return res;
    }
};
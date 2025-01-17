class Solution {
public:
    bool isPallindrome(string &s, int start, int end)
    {
        while(start <= end)
        {
            if(s[start] != s[end])
            return false;

            start++;
            end--;
        }
        return true;
    }

    vector<string> temp;
    vector<vector<string>> res;
    void backTrack(string &s, int index)
    {
        if(index == s.length())
        {
            res.push_back(temp);
            return;
        }

        string curr = "";
        for(int i = index; i < s.length(); i++)
        {
            // generating the string
            curr.push_back(s[i]);

            if(isPallindrome(s, index, i))
            {
                temp.push_back(curr);
                backTrack(s, i + 1);

                // backTracking
                temp.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) 
    {
        backTrack(s, 0);
        return res;
    }
};
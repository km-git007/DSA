class Solution {
public:
    string makeFancyString(string s) 
    {
        // i for writing and j for reading
        int i = 0;
        for(int j = 0; j < s.length(); j++) 
        {
            s[i] = s[j];

            if(i >= 2 && s[i - 2] == s[j] && s[i - 1] == s[j]) {
                continue;
            }
                
            i++;
        }
        return s.substr(0, i);
    }
};
class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) 
    {
        int n = s.length();
        vector<int> sft(n,0);
        for(int i = 0; i < shifts.size(); i++)
        {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            
            sft[start] += (direction == 1 ? 1 : -1);
            if(end + 1 < n)
            sft[end + 1] -= (direction == 1 ? 1 : -1);
        }

        for(int i = 0; i < n; i++)
        {
            if(i > 0)
            sft[i] += sft[i - 1];

            s[i] = 'a' + (s[i] - 'a' + (sft[i] % 26) + 26) % 26;
        }

        return s;
    }
};
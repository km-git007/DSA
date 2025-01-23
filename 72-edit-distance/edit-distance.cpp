class Solution {
public:
    int minDistance(string s, string t) 
    {
        int n = s.length();
        int m = t.length();

        vector<int> curr(m + 1, 0);
        vector<int> prev(m + 1, 0);

        // Fill the first row
        // Inserting characters into `s`
        for (int j = 0; j <= m; j++) prev[j] = j; 

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 0; j < m + 1; j++)
            {
                if(j == 0)
                curr[j] = i;

                // characters match
                else if(s[i - 1] == t[j - 1])
                curr[j] = prev[j - 1];

                // characters don't match
                else
                curr[j] = 1 + min({prev[j - 1], curr[j - 1], prev[j]});
            }
            prev = curr;
        }
        return prev[m];
    }
};
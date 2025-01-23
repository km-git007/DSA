class Solution {
public:
    int minimumDeleteSum(string s, string t) 
    {
        int n = s.length();
        int m = t.length();

        vector<int> curr(m + 1, 0), prev(m + 1, 0);
        // Fill the first row  
        for (int j = 1; j <= m; j++) prev[j] = (int)t[j - 1] + prev[j - 1]; 
        
        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 0; j < m + 1; j++)
            {
                if(j == 0)
                curr[j] = (int)s[i - 1] + prev[j];
    
                // characters don't match
                else if(s[i - 1] != t[j - 1])
                {
                    int a = (int)t[j - 1], b = (int)s[i - 1];
                    curr[j] = min({a + b + prev[j - 1], a + curr[j - 1], b + prev[j]});
                }

                // characters match
                else
                curr[j] = prev[j - 1];
            }
            prev = curr;
        }

        return prev[m];
    }
};
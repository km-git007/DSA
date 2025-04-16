class Solution {
    public int numDistinct(String s, String t) 
    {
        int n = s.length(), m = t.length(); 
        int[] prev = new int[m + 1], curr = new int[m + 1];

        for(int i = 0; i <= n; i++)
        prev[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                curr[j] = prev[j] + prev[j - 1];

                else
                curr[j] = prev[j];
            }

            for(int j = 1; j <= m; j++)
            prev[j] = curr[j];
        }
        return prev[m];
    }
}
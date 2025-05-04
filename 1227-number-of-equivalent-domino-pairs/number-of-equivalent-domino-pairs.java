class Solution 
{
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        int[][] count = new int[10][10];  // count[i][j] stores frequency of (i, j)
        int res = 0;
        for (int[] dom : dominoes) 
        {
            int a = Math.min(dom[0], dom[1]);
            int b = Math.max(dom[0], dom[1]);
            res += count[a][b];
            count[a][b]++;
        }
        return res;
    }
}
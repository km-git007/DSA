class Solution {

    private int maxLength;
    private Map<Integer, Integer> map;
    private int[][] dp;
    public int solve(int j, int k, int[] arr)
    {
        if(dp[j][k] != -1)
        return dp[j][k];

        int num = arr[k] - arr[j];

        if(map.containsKey(num) && map.get(num) < j)
        return dp[j][k] = 1 + solve(map.get(num), j, arr);

        return dp[j][k] = 2;
    }

    public int lenLongestFibSubseq(int[] arr) 
    {
        maxLength = 0;
        map = new HashMap<>();
        dp = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++)
        Arrays.fill(dp[i], -1);
        
        for(int i = 0; i < arr.length; i++)
        map.put(arr[i], i);
        
        for(int j = 1; j < arr.length; j++)
        {
            for(int k = j + 1; k < arr.length; k++)
            {
                int length = solve(j, k, arr);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength > 2 ? maxLength : 0;
    }
}
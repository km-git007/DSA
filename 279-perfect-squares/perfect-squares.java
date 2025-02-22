class Solution {

    private HashMap<Integer, Integer> memo;
    private int solve(int target) 
    {
        if (target == 0) return 0;
        if (memo.containsKey(target)) return memo.get(target);

        int minCount = Integer.MAX_VALUE;
        for (int j = 1; j * j <= target; j++) 
        {
            int take = 1 + solve(target - j * j); 
            minCount = Math.min(minCount, take);
        }

        memo.put(target, minCount);
        return minCount;
    }

    public int numSquares(int n) 
    {
        memo = new HashMap<>();
        return solve(n);
    }
}
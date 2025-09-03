class Solution {
    public int countTexts(String pressedKeys) {
        Set<Character> set = new HashSet<>();
        set.add('7'); set.add('9');

        final int MOD = 1_000_000_007;
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--){
            char ch = pressedKeys.charAt(i);
            int loop = set.contains(ch) ? 4 : 3;
            for(int k = i; k - i < loop && k < n; k++){
                if(pressedKeys.charAt(k) != ch){
                    break;
                }
                dp[i] = (dp[i] + dp[k + 1]) % MOD;
            }
        }
        return dp[0];
    }
}
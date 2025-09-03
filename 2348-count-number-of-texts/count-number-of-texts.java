class Solution {
    private Set<Character> set;
    private final int MOD = 1_000_000_007;
    private int[] dp;
    private int count(int index, String s){
        if(index >= s.length()){
            return 1;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }

        char ch = s.charAt(index);
        int loop = set.contains(ch) ? 4 : 3;
        int ways = 0;

        for(int k = index; k - index < loop && k < s.length(); k++){
            if(s.charAt(k) != ch){
                break;
            }
            ways = (ways + count(k + 1, s)) % MOD;
        }
        return dp[index] = ways;
    }

    public int countTexts(String pressedKeys) {
        set = new HashSet<>();
        set.add('7');
        set.add('9');

        dp = new int[pressedKeys.length()];
        Arrays.fill(dp, -1);
        return count(0, pressedKeys);
    }
}
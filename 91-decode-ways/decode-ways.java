class Solution {

    private int[] dp;
    private int decode(int index, String s){
        if(index >= s.length()){
            return 1;
        }

        // leading zero found, so return '0'. this is invalid grouping
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        int ways = decode(index + 1, s);
        if(index + 1 < s.length() && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))){
            ways += decode(index + 2, s);
        }

        return dp[index] = ways;
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(0, s);
    }
}
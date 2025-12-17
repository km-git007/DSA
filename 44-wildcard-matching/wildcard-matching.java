class Solution {
    private Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return recursiveMatch(0, 0, s, p);
    }

    private boolean recursiveMatch(int i, int j, String s, String p) {
        if(j == p.length()) {
            return i == s.length();
        }

        if(i == s.length()) {
            // Check if remaining pattern characters are all '*'
            for(int k = j; k < p.length(); k++) {
                if(p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = recursiveMatch(i + 1, j + 1, s, p);
        }

        if(p.charAt(j) == '*'){
            return dp[i][j] = recursiveMatch(i + 1, j, s, p) || recursiveMatch(i, j + 1, s, p);
        }

        return dp[i][j] = false;
    }
}
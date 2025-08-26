class Solution {
    public int longestCommonSubsequence(String s, String t)
    {
        int[] prev = new int[t.length() + 1];
        int[] curr = new int[t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    curr[j] = prev[j - 1] + 1;
                }else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            System.arraycopy(curr, 1, prev, 1, t.length());
        }
        return prev[t.length()];
    }
}
class Solution {
    public int numDistinct(String s, String t){
        int[] prev = new int[t.length() + 1];
        prev[0] = 1;
        int[] curr = new int[t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    curr[j] = prev[j - 1] + prev[j];
                }
                else {
                    curr[j] = prev[j];
                }
            }
            System.arraycopy(curr, 1, prev, 1, t.length());
        }
        return prev[t.length()];
    }
}
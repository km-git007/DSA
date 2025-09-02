
class Solution {
    public int numDistinct(String s, String t) {
        int[] prev = new int[t.length() + 1];
        prev[0] = 1;
        int[] curr = new int[t.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                int count = 0;
                count += prev[j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    count+= prev[j - 1];
                }
                curr[j] = count;
            }

            for(int j = 1; j <= t.length(); j++){
                prev[j] = curr[j];
            }
        }
        return prev[t.length()];
    }
}
class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    public int maxVowels(String s, int k)
    {
        int maxVowels = 0, i = 0, count = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(isVowel(ch)){
                count++;
            }
            
            if(j - i + 1 == k){
                maxVowels = Math.max(maxVowels, count);
                ch = s.charAt(i);
                if(isVowel(ch)){
                    count--;
                }
                i++;
            }
        }
        return maxVowels;
    }
}
class Solution {
        // Returns true if the character is a vowel.
    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i';
    }

    public int maxFreqSum(String s) {
        int[] count = new int[26];
        int maxVowelCount = 0, maxConsonantCount = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                maxVowelCount = Math.max(maxVowelCount, ++count[ch - 'a']);
            }else{
                maxConsonantCount = Math.max(maxConsonantCount, ++count[ch - 'a']);
            }
        }
        return maxConsonantCount + maxVowelCount;
    }
}
class Solution {
    public int maxVowels(String s, int k)
    {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        int maxVowels = 0, i = 0, count = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(vowelSet.contains(ch)){
                count++;
            }

            if(j - i + 1 == k){
                maxVowels = Math.max(maxVowels, count);
                ch = s.charAt(i);
                if(vowelSet.contains(ch)){
                    count--;
                }
                i++;
            }
        }
        return maxVowels;
    }
}
class Solution {
    public boolean areAlmostEqual(String s1, String s2) 
    {
        int n = s1.length();
        int[] freq = new int[26];
        for(int i  = 0; i < n; i++)
        {
            int ch1 = s1.charAt(i);
            int ch2 = s2.charAt(i);

            freq[ch1 - 'a']++;
            freq[ch2 - 'a']--;
        }

        for(int i  = 0; i < 26; i++)
        if(freq[i] != 0)
        return false;

        int violations = 0;
        for(int i  = 0; i < n; i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            violations++;

            if(violations > 2)
            return false;
        }
        // for anagrams the violations can't be 1
        // it has to be even i.e 0 or 2
        return violations <= 2;
    }
}
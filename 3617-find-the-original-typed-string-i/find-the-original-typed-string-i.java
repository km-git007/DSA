class Solution 
{
    public int possibleStringCount(String word) 
    {
        // Step 1: Start with 1 possible original (no error case)
        int ans = 1;

        // Step 2: Loop through the word
        for (int i = 1; i < word.length(); i++) 
        {
            // Step 3: Check for adjacent duplicates
            if (word.charAt(i) == word.charAt(i - 1)) 
            {
                // Step 4: Each duplicate adds 1 more possible original
                ans++; 
            }
        }

        // Step 5: Return total possible original strings
        return ans;
    }
}
class Solution {
    public boolean isPalindrome(String s) 
    {
        int start = 0, end = s.length() - 1;

        while (start <= end) 
        {
            // Skip non-alphanumeric characters
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}

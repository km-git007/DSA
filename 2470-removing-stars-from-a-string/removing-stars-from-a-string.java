class Solution {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (ans.length() > 0) { // Check if there is a character to remove
                    ans.deleteCharAt(ans.length() - 1); // Remove the last character
                }
            } else {
                ans.append(s.charAt(i)); // Add the current character to the result
            }
        }
        
        return ans.toString(); // Convert StringBuilder to String and return
    }
}

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String query : queries) {
            for (String word : dictionary) {
                if (isWithinTwoEdits(query, word)) {
                    result.add(query);
                    break;  // Found a match, move to next query
                }
            }
        }
        
        return result;
    }
    
    private boolean isWithinTwoEdits(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int edits = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                edits++;
                if (edits > 2) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
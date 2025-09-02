class Solution {
    private List<List<String>> res;
    private List<String> list;
    private boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private void generatePalindromePartition(String str) {
        if(str.isEmpty()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            if(isPalindrome(prefix)){
                list.add(prefix);
                generatePalindromePartition(str.substring(i + 1));
                list.removeLast();
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        generatePalindromePartition(s);
        return res;
    }
}
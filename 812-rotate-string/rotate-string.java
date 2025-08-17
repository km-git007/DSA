class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() != s.length()){
            return false;
        }
        String string = s + s;
        return string.contains(goal);
    }
}
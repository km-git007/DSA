class Solution {

    private String removeSubstrings(String s, String match)
    {
        StringBuilder sb = new StringBuilder(s);
        // i for writing and j for reading
        int i = 0, j = 0;
        while (j < s.length()) {
            sb.setCharAt(i, s.charAt(j));
            i++;

            if(i >= 2 && sb.charAt(i - 2) == match.charAt(0) && sb.charAt(i - 1) == match.charAt(1)) {
                i -= 2;
            }

            j++;
        }
        return sb.substring(0, i);
    }

    public int maximumGain(String s, int x, int y)
    {
        String maxString = x >= y ? "ab" : "ba";
        String minString = x < y ? "ab" : "ba";

        int maxPoint = Math.max(x, y);
        int minPoint = Math.min(x, y);

        int score = 0;
        String stringAfterOnePass = removeSubstrings(s, maxString);
        score += ((s.length() - stringAfterOnePass.length()) / 2) * maxPoint;

        String stringAfterTwoPass = removeSubstrings(stringAfterOnePass, minString);
        score += ((stringAfterOnePass.length() - stringAfterTwoPass.length()) / 2) * minPoint;

        return score;
    }

}
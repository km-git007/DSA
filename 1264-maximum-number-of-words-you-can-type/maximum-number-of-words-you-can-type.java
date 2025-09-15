class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] brokenSet = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) {
            brokenSet[ch - 'a'] = true;
        }

        int count = 0;
        String[] textArray = text.split(" ");
        for (String word : textArray) {
            boolean hasBrokenLetter = false;
            for (char ch : word.toCharArray()) {
                if (brokenSet[ch - 'a']) {
                    hasBrokenLetter = true;
                    break;
                }
            }
            if (!hasBrokenLetter) count++;
        }
        return count;
    }
}
class Solution {
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;

        boolean hasConsonant = false, hasVowel = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch))
                return false;

            else if (isVowel(ch))
                hasVowel = true;

            else if (!Character.isDigit(ch))
                hasConsonant = true;
        }

        return hasConsonant && hasVowel;
    }
}

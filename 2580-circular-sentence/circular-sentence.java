class Solution {
    public boolean isCircularSentence(String sentence) 
    {
        int n = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(n - 1))
        return false;

        int index = 0;
        while(index < n)
        {
            if(sentence.charAt(index) == ' ')
            {
                if(sentence.charAt(index-1) != sentence.charAt(index + 1))
                return false;
            }
            index++;
        }
        return true;
    }
}
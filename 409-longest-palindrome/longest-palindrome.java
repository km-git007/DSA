class Solution {
    public int longestPalindrome(String s) 
    {
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        boolean hasOdd=false;
        int length=0;
        for(char key : map.keySet())
        {
            int freq=map.get(key);
            if(freq%2==0)
            length+=freq;
            else
            {
                length+=freq-1;
                hasOdd=true;
            }
        }
        return (hasOdd)?length+1:length;
    }
}
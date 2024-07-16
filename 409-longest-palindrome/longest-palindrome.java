class Solution {
    public int longestPalindrome(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            // Get the current count of the character or default to 0 if not present
            int count = map.getOrDefault(c, 0);
            // Update the count
            map.put(c,count+1);
        }

        boolean hasOdd=false;
        int res=0;
        for(Integer val : map.values())
        {
            res+=val-val%2;
            if(val%2==1)
            hasOdd=true;
        }
        return res+(hasOdd?1:0);
    }
}
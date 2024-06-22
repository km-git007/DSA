class Solution {
    public int longestOnes(int[] a, int k) 
    {
        int zeroes=0,i=0;
        int maxLength=0;
        for(int j=0;j<a.length;j++)
        {
            if(a[j]==0)
            zeroes++;

            if(zeroes>k)
            {
                if(a[i]==0)
                zeroes--;
                i++;
            }
            
            if(zeroes<=k)
            maxLength=Math.max(maxLength,j-i+1);
        }
        return maxLength;
    }
}
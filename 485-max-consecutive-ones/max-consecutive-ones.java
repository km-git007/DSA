class Solution {
    public int findMaxConsecutiveOnes(int[] a) 
    {
        int count=0;
        int maxConsecutiveOnes=0;
        for(int i=0;i<a.length;i++)
        {
            count=(a[i]==1)?count+1:0;
            maxConsecutiveOnes=Math.max(maxConsecutiveOnes,count);
        }
        return maxConsecutiveOnes;
    }
}
class Solution {
    public int chalkReplacer(int[] chalks, int K) 
    {
        long sum=0;
        long k=K;
        for(int chalk : chalks)
        sum+=chalk;

        k=k%sum;

        for(int i=0;i<chalks.length;i++)
        {
            if(chalks[i]>k)
            return i;

            k-=chalks[i];
        }
        return -1;
    }
}
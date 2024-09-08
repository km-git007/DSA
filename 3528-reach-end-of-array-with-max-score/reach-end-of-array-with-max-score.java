class Solution {

    public long findMaximumScore(List<Integer> nums) 
    {
        int prevIndex=0;
        int maxi=nums.get(0);
        long score=0;
        int n=nums.size();
        for(int i=1;i<n;i++)
        {
            int num=nums.get(i);
            if(maxi<num)
            {
                score+=(long)(i-prevIndex)*(long)nums.get(prevIndex);
                maxi=num;
                prevIndex=i;
            }
        }

        if(prevIndex!=n-1)
        score+=(long)(n-1-prevIndex)*(long)nums.get(prevIndex);

        return score;
    }
}
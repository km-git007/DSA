class Solution {
    public long maxSum(List<Integer> nums, int m, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0,ans=0;
        int i=0;
        for(int j=0;j<nums.size();j++)
        {
            int num=nums.get(j);
            sum+=num;
            map.put(num,map.getOrDefault(num,0)+1);
            if(j-i+1==k)
            {
                if(map.size()>=m)
                ans=Math.max(ans,sum);

                int temp=nums.get(i);
                map.put(temp,map.get(temp)-1);
                if(map.get(temp)==0)
                map.remove(temp);
                sum-=temp;
                i++;
            }
        }
        return ans;
    }
}
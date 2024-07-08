class Solution {

    public int subarraysWithatMostKDistinct(int[] nums, int k)
    {
        if(k==0)
        return 0;

        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0,i=0;
        for(int j=0;j<nums.length;j++)
        {
            // if(map.containsKey(nums[j]))
            // map.put(nums[j],map.get(nums[j])+1);
            // else
            // map.put(nums[j],1);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            
            while(map.size()>k)
            {
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)
                map.remove(nums[i]);
                i++;
            }
            count+=j-i+1;
        }
        return count;
    } 

    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        return subarraysWithatMostKDistinct(nums,k)-subarraysWithatMostKDistinct(nums,k-1);
    }
}
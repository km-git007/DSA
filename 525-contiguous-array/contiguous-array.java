class Solution {
    public int findMaxLength(int[] nums) 
    {   
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            nums[i] = -1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int pSum = 0, maxLength = 0;
        for(int i = 0; i < nums.length; i++)
        {
            pSum += nums[i];

            if(map.containsKey(pSum))
            maxLength = Math.max(maxLength, i - map.get(pSum));
            else
            map.put(pSum, i);
        }
        return maxLength;
    }
}
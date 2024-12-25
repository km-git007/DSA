class Solution {
    public int findMaxLength(int[] nums) 
    {    
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int pSum = 0, maxLength = 0;
        for(int i = 0; i < nums.length; i++)
        {
            pSum += (nums[i] == 1 ? 1 : -1);

            if(map.containsKey(pSum))
            maxLength = Math.max(maxLength, i - map.get(pSum));
            else
            map.put(pSum, i);
        }
        return maxLength;
    }
}
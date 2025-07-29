class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
        int[] map = new int[k];
        map[0] = 1;
        int prefixSum = 0, count = 0;
        for(int num : nums)
        {
            prefixSum += num;
            int remainder = prefixSum % k;
            if(remainder < 0) remainder += k;
            
            if(map[remainder] > 0){
                count += map[remainder];
            }
            map[remainder] += 1;
        }
        return count;
    }
}
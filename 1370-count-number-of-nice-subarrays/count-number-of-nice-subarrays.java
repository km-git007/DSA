class Solution {

    public int numberOfSubarrays(int[] nums, int k) 
    {
        return solve(nums, k) - solve(nums, k - 1);
    }

    // return number Of Subarrays Having Less Than Equal to K odd Numbers
    public int solve(int[] nums, int k) 
    {
        int count = 0, i = 0;
        int oddCount = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] % 2 == 1)
            oddCount++;

            while(i <= j && oddCount > k)
            {
                if(nums[i] % 2 == 1)
                oddCount--;

                i++;
            }

            count += j - i + 1;
        }
        return count;
    }
}
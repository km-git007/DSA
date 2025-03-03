class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
        int n = nums.length;
        int[] res = new int[n];

        int countLessThanPivot = 0, countEqualToPivot = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == pivot)
            countEqualToPivot++;

            else if(nums[i] < pivot)
            countLessThanPivot++;
        }

        int i = 0, j = countLessThanPivot, k = countLessThanPivot + countEqualToPivot;
        for(int num : nums)
        {
            if(num < pivot)
            res[i++] = num;

            else if(num == pivot)
            res[j++] = num;

            else
            res[k++] = num;
        }
        return res;
    }
}
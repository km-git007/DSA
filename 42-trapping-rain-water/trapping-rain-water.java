class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while(left < right)
        {
            if(height[left] > height[right])
            {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
            else
            {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            }
        }
        return water;
    }
}
class Solution {
public:
    int trap(vector<int>& height) 
    {
        int n = height.size();
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int water = 0;
        while(left < right)
        {
            if(height[left] > height[right])
            {
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
            else
            {
                leftMax = max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            }
        }
        return water;
    }
};
class Solution {
    public int trap(int[] height) 
    {
        // finding the tower with maximum height;
        // calculating water trapped between 0th -> max height tower 
        // then calculating water trapped between max height tower -> nth tower

        int maxHeight=height[0];
        int index=0;
        for(int i=1;i<height.length;i++)
        {
            if(height[i]>maxHeight)
            {
                maxHeight=height[i];
                index=i;
            }
        }

        int leftMax=height[0];
        int water=0;
        for(int i=1;i<index;i++)
        {
            leftMax=Math.max(leftMax,height[i]);
            water+=leftMax-height[i];
        }

        int rightMax=height[height.length-1];
        for(int i=height.length-2;i>index;i--)
        {
            rightMax=Math.max(rightMax,height[i]);
            water+=rightMax-height[i];
        }

        return water;
    }
}
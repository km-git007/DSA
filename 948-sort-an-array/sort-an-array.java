class Solution {

    public void merge(int[] nums,int low,int high,int mid)
    {
        int[] temp=new int[high-low+1];
        int i=low,j=mid+1,index=0;
        while(i<=mid && j<=high)
        {
            if(nums[i]<=nums[j])
            {
                temp[index]=nums[i];
                index++;
                i++;
            }
            else
            {
                temp[index]=nums[j];
                index++;
                j++;
            }
        }

        while(i<=mid)
        {
            temp[index]=nums[i];
            index++;
            i++;
        }

        while(j<=high)
        {
            temp[index]=nums[j];
            index++;
            j++;
        }

        for(int k=0;k<temp.length;k++)
        nums[k+low]=temp[k];
    }

    public void mergeSort(int[] nums,int low,int high)
    {
        if(low>=high)
        return;

        int mid=low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,high,mid);
    }

    public int[] sortArray(int[] nums) 
    {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}
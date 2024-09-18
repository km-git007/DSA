class Solution {
    public String largestNumber(int[] arr) 
    {
        // Have to do this because custom comparator can't be use for primitive data types.
        Integer[] nums=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
        nums[i]=arr[i];

        Arrays.sort(nums,(a,b) -> {
            String s1=String.valueOf(a);
            String s2=String.valueOf(b);
            return (s2+s1).compareTo(s1+s2);
        });   

        // Edge case: if the largest number is "0", return "0"
        if(nums[0] == 0) 
        return "0";

        String ans="";
        for(int num : nums)
        ans+=Integer.toString(num);

        return ans;
    }
}
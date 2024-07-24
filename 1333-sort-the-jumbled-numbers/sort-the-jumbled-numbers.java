class Solution {

    private int newNumber(int num,int[] mapping)
    {
        if(num==0)
        return mapping[0];
        
        int multiplier=1;
        int newNumber=0;
        while(num>0)
        {
            int mappedNumber=mapping[num%10];
            newNumber+=(mappedNumber*multiplier);
            num/=10;
            multiplier*=10;
        }
        return newNumber;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) 
    {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int mappedNumber=newNumber(nums[i],mapping);
            list.add(new int[]{mappedNumber,nums[i],i});
        }

        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int value=a[0]-b[0];
                if(value!=0)
                return value;
                return a[2]-b[2];
            }
        });

        int[] res=new int[nums.length];
        for(int i=0;i<res.length;i++)
        res[i]=list.get(i)[1];

        return res;
    }
}
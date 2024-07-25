class Solution {
    public int[] frequencySort(int[] nums) 
    {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        List<int[]> list=new ArrayList<>();
        for(int key : map.keySet())
        list.add(new int[]{map.get(key),key});

        Collections.sort(list,(a,b)->{
            // sorting based on increasing frequency.
            if(a[0]!=b[0])
            return a[0]-b[0];
            // sorting based on decreasing value if frequency is same.
            return b[1]-a[1];
            }
        );

        int index=0;
        for(int i=0;i<list.size();i++)
        {
            int[] arr=list.get(i);
            int freq=arr[0];
            int value=arr[1];

            while(freq-- >0)
            nums[index++]=value;
        }
        return nums;
    }
}
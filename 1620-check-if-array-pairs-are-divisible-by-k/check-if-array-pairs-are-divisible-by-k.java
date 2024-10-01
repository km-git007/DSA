class Solution {
    public boolean canArrange(int[] arr, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : arr)
        {
            int rem=num%k;
            if(rem<0)
            rem+=k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        for(int num : arr)
        {
            int rem=num%k;
            if(rem<0)
            rem+=k;
            int reqRemainder=k-rem;
            if(rem==0)
            {
                if(map.get(rem)%2!=0)
                return false;
                continue;
            }
            else if(map.containsKey(reqRemainder))
            {
                map.put(reqRemainder,map.get(reqRemainder)-1);
                if(map.get(reqRemainder)==0)
                map.remove(reqRemainder);
                System.out.println(reqRemainder);
            }
            else
            return false;
        }
        return true;
    }
}
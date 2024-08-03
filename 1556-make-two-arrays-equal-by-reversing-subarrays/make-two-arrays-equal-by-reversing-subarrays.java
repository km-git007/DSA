class Solution {
    public boolean canBeEqual(int[] target, int[] arr) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele : arr)
        map.put(ele,map.getOrDefault(ele,0)+1);

        for(int ele : target)
        {
            if(!map.containsKey(ele))
            return false;

            map.put(ele,map.get(ele)-1);
            if(map.get(ele)==0)
            map.remove(ele);
        }
        return true;
    }
}
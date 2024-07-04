class Solution {
    public int[] intersect(int[] a1, int[] a2) 
    {
        HashMap<Integer,Integer> map= new HashMap<>();
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i<a1.length;i++)
        {
            if(map.containsKey(a1[i]))
            map.put(a1[i],map.get(a1[i])+1);
            else
            map.put(a1[i],1);
        }

        for(int i=0;i<a2.length;i++)
        {
            if(map.containsKey(a2[i]))
            {
                res.add(a2[i]);
                map.put(a2[i],map.get(a2[i])-1);
                if(map.get(a2[i])==0)
                map.remove(a2[i]);
            }
        }

        // Convert ArrayList to int[]
        int[] result =new int[res.size()];
        for (int i=0;i<res.size();i++)
        result[i]=res.get(i);
        return result;
    }
}
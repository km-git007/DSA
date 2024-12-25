class Solution {
    public int longestConsecutive(int[] nums) 
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums)
        map.put(num, true);

        map.forEach((key, value) -> {
            if(map.containsKey(key - 1))
            map.put(key, false);
        });

        int maxLength = 0;
        for (Integer key : map.keySet())
        {
            if (map.get(key)) 
            { // Only start from true keys
                int length = 1;
                int current = key;
                while (map.containsKey(current + 1)) 
                {
                    current++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
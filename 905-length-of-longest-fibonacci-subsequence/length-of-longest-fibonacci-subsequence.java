class Solution {

    private int maxLength;
    private Map<Integer, Integer> map;
    public int solve(int j, int k, int[] arr)
    {
        int num = arr[k] - arr[j];

        if(map.containsKey(num) && map.get(num) < j)
        return 1 + solve(map.get(num), j, arr);

        return 2;
    }

    public int lenLongestFibSubseq(int[] arr) 
    {
        maxLength = 0;
        map = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        map.put(arr[i], i);
        
        for(int j = 1; j < arr.length; j++)
        {
            for(int k = j + 1; k < arr.length; k++)
            {
                int length = solve(j, k, arr);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength > 2 ? maxLength : 0;
    }
}
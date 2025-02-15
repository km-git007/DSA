class Solution {
    private int binarySearch(long spell, long target, int[] potions)
    {
        int start = 0;
        int end = potions.length - 1;       
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;

            if(spell * potions[mid] >= target) 
            end = mid - 1;
            
            else 
            start = mid + 1;
        }
        // return the number of potions that will yield success with the current spell
        return potions.length - start;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        // sort the potions array O(mlogm)
        Arrays.sort(potions);

        int n = spells.length;
        int[] pairs = new int[n];
        for(int i = 0; i < n; i++)
        {
            int noOfPotions = binarySearch((long)spells[i], success, potions);
            pairs[i] = noOfPotions;
        }

        return pairs;
    }
}
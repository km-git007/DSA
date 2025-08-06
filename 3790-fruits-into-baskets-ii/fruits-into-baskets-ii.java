class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) 
    {
        int n = fruits.length;
        boolean[] taken = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            int fruitQuantity = fruits[i];
            for(int j = 0; j < n; j++)
            {
                if(taken[j])
                continue;

                if(baskets[j] >= fruitQuantity)
                {
                    taken[j] = true;
                    break;
                }
            }
        }

        int unplacedFruits = 0;
        for(int i = 0; i < n; i++)
        {
            if(!taken[i])
            unplacedFruits++;
        }
        return unplacedFruits;
    }
}
class Solution {
    private int getSum(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) 
    {
        int[] map = new int[37];
        int maxSize = 0;
        for(int num = 1; num <= n; num++)
        {
            int sum = getSum(num);
            map[sum]++;
            maxSize = Math.max(maxSize, map[sum]);
        }

        int count = 0;
        for (int size : map) 
        {
            if(size == maxSize)
            count++;
        }
        return count;
    }
}
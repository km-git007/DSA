class Solution {
    private int getSum(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public int countBalls(int low, int high) 
    {
        // number with biggest sum = 99999 i.e '45'
        // hence max size of the map should me 46
        int[] map = new int[46];

        int maxBalls = 0;
        for(int i = low; i <= high; i++)
        {
            int sum = getSum(i);
            map[sum]++;

            maxBalls = Math.max(maxBalls, map[sum]);
        }
        return maxBalls;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n = gas.length;

        int startIndex = 0, currGas = 0;
        int total = 0;
        for(int i = 0; i < n; i++)
        {
            int diff = gas[i] - cost[i];
            currGas += diff;
            total += diff;

            if(currGas < 0)
            {
                startIndex = i + 1;
                currGas = 0;
            }
        }
        return total >= 0 ? startIndex : -1;
    }
}
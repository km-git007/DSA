class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int index=0,units=0;
        while(index<boxTypes.length && truckSize>0)
        {
            int boxes=Math.min(truckSize,boxTypes[index][0]);
            units+=boxes*boxTypes[index][1];
            truckSize-=boxTypes[index][0];
            index++;
        }
        return units;
    }
}
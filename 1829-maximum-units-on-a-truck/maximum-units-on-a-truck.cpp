class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) 
    {
        // Sort boxTypes based on the number of units per box in descending order
        sort(boxTypes.begin(), boxTypes.end(), [](vector<int>& a, vector<int>& b){
            return b[1] < a[1];  // sort based on second element in descending order
        });

        int index=0;
        int maxUnits=0;
        while (index<boxTypes.size() && truckSize>0) 
        {
            int boxes=min(truckSize,boxTypes[index][0]);  // minimum of truck size and available boxes
            maxUnits+=boxes*boxTypes[index][1];  // calculate units
            truckSize-=boxes;  // reduce truck size by the number of boxes loaded
            index++;  // move to the next type of box
        }
        return maxUnits;
    }
};
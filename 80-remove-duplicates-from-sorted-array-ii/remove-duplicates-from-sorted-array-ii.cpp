class Solution {
public:
    int removeDuplicates(vector<int>& a) 
    {
        int i=0,insertionIndex=0;
        while(i<a.size())
        {
            int startIndex=i;
            while(i<a.size()-1 && a[i]==a[i+1])
            i++;

            int count=i-startIndex+1;
            int freq=min(count,2);
            while(freq--)
            {
                a[insertionIndex]=a[startIndex];
                insertionIndex++;
            }
            i++;
        }
        return insertionIndex;
    }
};
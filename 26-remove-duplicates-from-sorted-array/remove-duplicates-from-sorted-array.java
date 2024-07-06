class Solution {
    public int removeDuplicates(int[] a) 
    {
        int index=1;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]!=a[i-1])
            {
                a[index]=a[i];
                index++;
            }
        }
        return index;
    }
}
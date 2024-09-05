class Solution {

    private int[] solve(int sum,int n)
    {
        int[] arr=new int[n];
        int val=sum/n;
        sum%=n;
        for(int i=0;i<n;i++)
        {
            arr[i]=val+((sum>0)?1:0);
            sum--;
        }
        return arr;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) 
    {
        int sum=0,m=rolls.length;
        for(int roll : rolls)
        sum+=roll;

        int missingSum=(mean*(m+n))-sum;
        if(missingSum>6*n || missingSum<1*n)
        return new int[]{};

        return solve(missingSum,n);
    }
}
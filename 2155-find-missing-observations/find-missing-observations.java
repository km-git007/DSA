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

        int requiredSum=(mean*(m+n))-sum;
        if(requiredSum>6*n || requiredSum<1*n)
        return new int[]{};

        return solve(requiredSum,n);
    }
}
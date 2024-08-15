class Solution {
    public int splitNum(int num) 
    {
        List<Integer> list=new ArrayList<>();
        while(num>0)
        {
            list.add(num%10);
            num/=10;
        }

        // sorting the list 
        Collections.sort(list);

        int n=list.size();
        int num1=0,num2=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            num1=num1*10+list.get(i);
            else
            num2=num2*10+list.get(i);
        }
        return num1+num2;
    }
}
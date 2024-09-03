class Solution {

    private int convert(String s)
    {
        int num=0;
        for(char c : s.toCharArray())
        {
            int temp=c-'a'+1;
            if(temp>9)
            temp=temp/10+temp%10;
            num+=temp;
        }
        return num;
    }

    private int transform(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

    public int getLucky(String s, int K) 
    {
        int num=convert(s);
        System.out.println(num);
        int k=K-1;

        while(k>0)
        {
            num=transform(num);
            k--;
        }
        return num;
    }
}
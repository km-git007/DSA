class Solution {
    public String addBinary(String a, String b) 
    {
        String ans="";
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0)
        {
            int sum=carry;
            if(i>=0)
            {
                sum+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0)
            {
                sum+=b.charAt(j)-'0';
                j--;
            }

            if(sum>1) 
            {
                ans=Integer.toString(sum%2)+ans;
                carry=1;
            }
            else
            {
                ans=Integer.toString(sum)+ans;
                carry=0;
            }
        }
        return ans;
    }
}
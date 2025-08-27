class Solution {

    public String reverseString(String s){
        char[] ch =  s.toCharArray();
        int l=0,r=ch.length-1;
        while(l<r){
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
        return new String(ch);
    }

    public int lcs(String s){
        String rs = reverseString(s);
        int n=s.length();
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            int prev = 0;
            for(int j=1;j<=n;j++){
                int tmp = dp[j];
                if(s.charAt(i-1) == rs.charAt(j-1)){
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                prev = tmp;
            }
        }
        return n - dp[n];
    }

    public int minInsertions(String s) {
        Callable<Integer> callable=()->lcs(s);
        FutureTask<Integer>future=new FutureTask<>(callable);
        new Thread(future).start();
        try{
            return future.get();
        }catch(Exception e){
            return 0;
        }
    }
}
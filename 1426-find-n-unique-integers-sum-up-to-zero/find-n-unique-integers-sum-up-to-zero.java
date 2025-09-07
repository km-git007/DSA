class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int num = - n / 2;
        for(int i = 0; i < n; i++){
            if(n % 2 == 0 && num == 0){
                num++;
            }
            res[i] = num;
            num++;
        }
        return res;
    }
}
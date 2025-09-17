class Solution {
    private boolean isValid(long n, long k) {
        long sum = (k * (k + 1)) / 2;
        return sum <= n;
    }

    public int arrangeCoins(int n) {
        long start = 1, end = n, res = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if(isValid(n, mid)){
                res = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (int)res;
    }
}
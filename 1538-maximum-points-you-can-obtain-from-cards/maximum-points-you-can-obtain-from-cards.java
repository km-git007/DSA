class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowSize = cardPoints.length - k;
        int sum = 0, totalSum = 0, minSum = Integer.MAX_VALUE, i = 0;
        for(int j = 0; j < cardPoints.length; j++) {
            sum += cardPoints[j];
            totalSum += cardPoints[j];
            if(j - i + 1 == windowSize){
                minSum = Math.min(minSum, sum);
                sum -= cardPoints[i];
                i++;
            }
        }
        return k == cardPoints.length ? totalSum : totalSum - minSum;
    }
}
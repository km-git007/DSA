class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            dailyTemperatures(new int[] {});
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int top = -1;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            while (top>-1&&temperatures[i]>temperatures[stack[top]]) {
                int index=stack[top--];
                result[index] = i-index;
                
            }
            stack[++top]=i;
        }
        return result;
    }
}
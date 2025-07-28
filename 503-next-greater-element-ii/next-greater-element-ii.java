class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        int index;
        for(int i = 2*n - 1; i >= 0; i--)
        {
            index = i % n;
            while(!stack.isEmpty() && stack.peek() <= nums[index]){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                res[index] = stack.peek();
            }

            stack.push(nums[index]);
        }
        return res;
    }
}
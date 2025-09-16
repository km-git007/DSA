class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private long lcm(int a, int b, int gcd) {
        return ((long)a * b) / gcd;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && gcd(stack.peek(), num) > 1) {
                int top = stack.pop();
                num = (int)lcm(num, top, gcd(num, top));
            }
            stack.push(num);
        }

        List<Integer> res = new ArrayList<>(stack);
        Collections.reverse(res);
        return res;
    }
}

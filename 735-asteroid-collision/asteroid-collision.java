class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids) {
            if(stack.isEmpty() || asteroid > 0 || (asteroid < 0 && stack.peek() < 0)) {
                stack.push(asteroid);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        return result;
    }
}
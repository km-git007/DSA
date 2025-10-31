class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        int[] res = new int[2];
        for(int num : nums){
            if(set.contains(num)){
                res[index++] = num;
            }
            set.add(num);
        }
        return res;
    }
}
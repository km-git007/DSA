class Solution {

    public int[] resultsArray(int[] nums, int k) 
    {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> indexDeque = new ArrayDeque<>();
        for (int currentIndex = 0; currentIndex < length; currentIndex++) 
        {
            // Check if current element breaks the consecutive and sorted condition
            if(!indexDeque.isEmpty() &&nums[currentIndex] != nums[currentIndex - 1] + 1)
            indexDeque.clear(); // Invalidate the entire deque if condition breaks

            // Add current element index to the deque
            indexDeque.offerLast(currentIndex);

            // Check if the window is of size k and update result
            if (currentIndex >= k - 1) 
            {
                // Valid window of size >= k
                if(indexDeque.size() >= k)  
                result[currentIndex - k + 1] = nums[indexDeque.peekLast()];

                // Not valid, return -1
                else
                result[currentIndex - k + 1] = -1; 

                // Remove elements that are out of the window
                if(!indexDeque.isEmpty() && indexDeque.peekFirst() < currentIndex - k + 1) 
                indexDeque.pollFirst();
            }
        }

        return result;
    }
}
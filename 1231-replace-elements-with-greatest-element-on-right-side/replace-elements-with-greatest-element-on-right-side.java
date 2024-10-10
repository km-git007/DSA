class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int n = arr.length;
        int[] ans = new int[n];
        int greatest = -1;  // Start with -1 for the last element

        // Iterate from the last element to the first
        for (int i = n - 1; i >= 0; i--) 
        {
            ans[i] = greatest;  // Store the greatest element encountered so far
            if(arr[i] > greatest) 
            greatest = arr[i];  // Update the greatest element
        }
        return ans;
    }
}
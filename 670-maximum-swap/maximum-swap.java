class Solution {
    public int maximumSwap(int number) 
    {
        // Convert the number to a string for easier manipulation
        StringBuilder s = new StringBuilder(String.valueOf(number));
        int n = s.length();
        
        // Array to track the index of the largest digit from the right
        int[] maxIndex = new int[n];
        int maxi = -1; // Maximum digit value so far
        
        // Traverse the digits from the end to the beginning
        for (int i = n - 1; i >= 0; i--) 
        {
            int num = s.charAt(i) - '0'; // Convert character to an integer
            if (num > maxi) 
            {
                maxIndex[i] = i;  // Update the maxIndex with the current position
                maxi = num;       // Update the maximum digit seen so far
            } 
            else 
                maxIndex[i] = maxIndex[i + 1]; // Carry forward the previous maxIndex
        }

        // Traverse the digits from the beginning to find the first digit to swap
        for (int i = 0; i < n; i++) 
        {
            int num = s.charAt(i) - '0'; // Convert character to integer
            if (num < s.charAt(maxIndex[i]) - '0') 
            {
                // Swap the current digit with the largest digit found on the right
                char temp = s.charAt(i);
                s.setCharAt(i, s.charAt(maxIndex[i]));
                s.setCharAt(maxIndex[i], temp);
                break; // We perform only one swap, so we can stop after the first swap
            }
        }
        // Convert the string back to an integer and return it
        return Integer.parseInt(s.toString());
    }
}
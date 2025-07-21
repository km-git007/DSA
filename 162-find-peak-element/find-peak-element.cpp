class Solution {
public:
    int binarySearch(vector<int>& nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == nums[mid - 1] && nums[mid] == nums[mid + 1]) {
                int left = binarySearch(nums, low, mid - 1);
                if (left != -1) return left;
                return binarySearch(nums, mid + 1, high);
            }

            if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1])  
                return mid;

            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    int findPeakElement(vector<int>& nums) {
        int n = nums.size();

        if (n == 1) return 0;
        if (nums[0] >= nums[1]) return 0;
        if (nums[n - 1] >= nums[n - 2]) return n - 1;

        return binarySearch(nums, 1, n - 2);
    }
};

class NumArray {
public:

    vector<int> pSum;
    NumArray(vector<int>& nums) 
    {
        pSum.resize(nums.size());
        pSum[0]=nums[0];

        for(int i=1;i<nums.size();i++)
        pSum[i]=pSum[i-1]+nums[i];
    }
        
    int sumRange(int left, int right) 
    {
        if(left==0)
        return pSum[right];
        
        return pSum[right]-pSum[left-1];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
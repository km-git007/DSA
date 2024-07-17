class Solution {
public:

    vector<int> nextSmaller(vector<int>& arr)
    {
        vector<int> nextSmaller(arr.size());
        stack<int> stack;
        for(int i=arr.size()-1;i>=0;i--)
        {
            while(!stack.empty() && arr[i]<=arr[stack.top()])
            stack.pop();

            if(stack.empty())
            nextSmaller[i]=arr.size();
            else
            nextSmaller[i]=stack.top();

            stack.push(i);
        }
        return nextSmaller;
    }

    vector<int> prevSmallerOrEqual(vector<int>& arr)   // for cases such as arr=[2,2,2]
    {
        vector<int> prevSmaller(arr.size());
        stack<int> stack;
        for(int i=0;i<arr.size();i++)
        {
            while(!stack.empty() && arr[i]<arr[stack.top()])
            stack.pop();

            if(stack.empty())
            prevSmaller[i]=-1;
            else
            prevSmaller[i]=stack.top();

            stack.push(i);
        }
        return prevSmaller;
    }

    int sumSubarrayMins(vector<int>& arr) 
    {
        vector<int> left=prevSmallerOrEqual(arr);
        vector<int> right=nextSmaller(arr);

        int mod=1e9+7;
        long long sum=0;
        for(int i=0;i<arr.size();i++)
        {
            long long product=((i-left[i])*(right[i]-i))%mod;
            product=(product*arr[i])%mod;
            sum=(sum+product)%mod;
        }
        return (int)sum;
    }
};
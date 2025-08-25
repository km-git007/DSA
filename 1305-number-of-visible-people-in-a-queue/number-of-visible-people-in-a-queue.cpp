class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        int n = heights.size();
        vector<int> numPeople(n, 0);
        stack<int> stack;
        for (int i = n - 1; i >= 0; --i) {
            int count = 0;
            while (!stack.empty() && stack.top() < heights[i]) {
                stack.pop();
                ++count;
            }
            numPeople[i] = stack.empty() ? count : count + 1;
            stack.push(heights[i]);
        }
        return numPeople;
    }
};

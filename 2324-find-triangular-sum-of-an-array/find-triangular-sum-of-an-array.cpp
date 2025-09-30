class Solution {
public:
    int triangularSum(vector<int>& prev) {
        vector<int> curr = prev;
        int currSize = prev.size();
        while(currSize > 1){
            for(int i = 1; i < currSize; i++){
                curr[i - 1] = (prev[i - 1] + prev[i]) % 10;
            }
            prev = curr;
            currSize--;
        }
        return curr[0];
    }
};
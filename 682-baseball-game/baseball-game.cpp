class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int>ans;
        int sum =0;
        for(const string& op:operations){
            if(op!="C" && op!="D" && op!="+"){
                int val = stoi(op);
                ans.push(val);
            }else if(op=="C"){
                ans.pop();
            }
            else if(op=="D"){
                int num = ans.top();
                ans.push(num*2);
            }else{
                int a = ans.top();ans.pop();
                int b = ans.top();
                ans.push(a);
                ans.push(a+b);
            }
        }
        while(!ans.empty()){
            sum += ans.top();
            ans.pop();
        }
        return sum;
    }
};
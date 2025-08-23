class Solution {
public:
    string removeKdigits(string num, int k) {
        string stack = "";  // Using string as stack
        
        for(char ch : num){
            while(!stack.empty() && k > 0 && stack.back() > ch){
                stack.pop_back();
                k--;
            }
            stack.push_back(ch);
        }
        
        // if not able to remove all k-digits 
        // remove the digits from the end of stack coz its monotonic increasing
        while(k > 0 && !stack.empty()){
            stack.pop_back();
            k--;
        }
        
        // remove the leading zeroes
        int index = 0;
        while(index < stack.length() && stack[index] == '0'){
            index++;
        }
        string result = stack.substr(index);
        return result.empty() ? "0" : result;
    }
};

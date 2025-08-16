class Solution {
public:
    int maximum69Number (int num) {
        string number = to_string(num);
        
        for (char &ch : number) {
            if (ch == '6') {
                ch = '9'; // change the first '6' to '9'
                break;    // only one change allowed
            }
        }
        
        return stoi(number);
    }
};

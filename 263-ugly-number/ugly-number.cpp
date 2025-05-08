class Solution {
public:
    bool isUgly(int n) {
        if (n <= 0) return false;  // Negative numbers and zero are not ugly

        // Divide out all 2s, 3s, and 5s
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        // After removing all 2s, 3s, and 5s, if n is 1, it was an ugly number
        return n == 1;
    }
};
class Solution {
public:
    string removeSubstrings(string &s, const string& match)
    {
        // i for writing and j for reading
        int i = 0, j = 0;
        while (j < s.length()) {
            s[i] = s[j];
            i++;

            if(i >= 2 && s[i - 2] == match[0] && s[i - 1] == match[1]) {
                i -= 2;
            }

            j++;
        }
        return s.substr(0, i);
    }

    int maximumGain(string s, int x, int y) {
        string maxString = (x >= y) ? "ab" : "ba";
        string minString = (x < y) ? "ab" : "ba";
        int maxPoint = max(x, y);
        int minPoint = min(x, y);

        string afterFirstPass = removeSubstrings(s, maxString);
        int firstGain = ((int)s.size() - (int)afterFirstPass.size()) / 2 * maxPoint;

        string afterSecondPass = removeSubstrings(afterFirstPass, minString);
        int secondGain = ((int)afterFirstPass.size() - (int)afterSecondPass.size()) / 2 * minPoint;

        return firstGain + secondGain;
    }
};

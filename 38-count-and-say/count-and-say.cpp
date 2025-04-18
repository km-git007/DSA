class Solution {
public:
    string countAndSay(int N) 
    {
        if(N == 1)
        return "1";

        int n = 2;
        string s = "11#", res = "";
        while(n < N)
        {
            int index = 0, count = 1;
            while(index < s.length() - 1)
            {
                while(index < s.length() - 1 && s[index] == s[index + 1])
                {
                    index++;
                    count++;
                }

                //keep generateing the new string
                res.push_back(count + '0');
                res.push_back(s[index]);

                // move the index and reset count
                index++;
                count = 1;
            }

            res.push_back('#');
            s = res;
            res.clear();
            n++;
        }
        s.pop_back();
        return s;
    }
};
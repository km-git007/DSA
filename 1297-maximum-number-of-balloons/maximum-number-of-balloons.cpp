class Solution {
public:
    int maxNumberOfBalloons(string text) 
    {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for(char ch : text)
        {
            switch(ch)
            {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }

        // Since 'l' and 'o' appear twice in "balloon"
        l /= 2;
        o /= 2;

        return min({b, a, l, o, n});
    }
};

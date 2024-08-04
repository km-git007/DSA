class Solution {
public:
    bool judgeCircle(string moves) 
    {
        int up=0,left=0;
        for(int i=0;i<moves.length();i++)
        {
            switch(moves[i])
            {
                case 'U' :  up++;
                break;

                case 'D' :  up--;
                break;

                case 'L' :  left++;
                break;

                case 'R' :  left--;
                break;
            }
        }
        return (!up && !left);
    }
};
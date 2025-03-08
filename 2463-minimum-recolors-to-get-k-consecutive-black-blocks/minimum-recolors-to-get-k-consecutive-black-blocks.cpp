class Solution {
public:
    int minimumRecolors(string blocks, int k) 
    {
        int i = 0, minOper = k, count = 0;
        for(int j = 0; j < blocks.size(); j++)
        {
            if(blocks[j] == 'W')
            count++;

            if(j - i + 1 == k)
            {
                minOper = min(minOper, count);

                if(blocks[i] == 'W')
                count--;

                i++;
            }
        }
        return minOper;
    }
};
class Solution {
public:
    int calPoints(vector<string>& operations) 
    {
        vector<int> temp;
        temp.push_back(stoi(operations[0]));
        for(int i=1;i<operations.size();i++)
        {
            if(operations[i]=="C")
                temp.pop_back();
            else if(operations[i]=="D")
            {
                int score=temp.back();
                temp.push_back(2*score);
            }
            else if(operations[i]=="+")
            {
                int firstPreviousScore=temp.back();
                temp.pop_back();
                int secondPreviousScore=temp.back();
                temp.push_back(firstPreviousScore);
                temp.push_back(firstPreviousScore+secondPreviousScore);
            }
            else
            temp.push_back(stoi(operations[i]));
        }

        int totalScore=0;
        for(int score : temp)
        totalScore+=score;

        return totalScore;
    }
};
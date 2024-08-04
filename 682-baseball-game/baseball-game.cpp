class Solution {
public:
    int calPoints(vector<string>& oper) 
    {
        stack<int> temp;
        temp.push(stoi(oper[0]));
        for(int i=1;i<oper.size();i++)
        {
            if(oper[i]=="C")
                temp.pop();
            else if(oper[i]=="D")
            {
                int score=temp.top();
                temp.push(2*score);
            }
            else if(oper[i]=="+")
            {
                int firstPreviousScore=temp.top();
                temp.pop();
                int secondPreviousScore=temp.top();
                temp.push(firstPreviousScore);
                temp.push(firstPreviousScore+secondPreviousScore);
            }
            else
            temp.push(stoi(oper[i]));
        }

        int totalScore=0;
        while(!temp.empty())
        {
            totalScore+=temp.top();
            temp.pop();
        }
        return totalScore;
    }
};
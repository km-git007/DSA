class Solution {
public:
    vector<int> asteroidCollision(vector<int>& ast) 
    {
        vector<int> ans;
        int i=0;
        while(i<ast.size())
        {
            if(ans.size()==0 || ast[i]>0 || ans.back()*ast[i]>=0)
            ans.push_back(ast[i]);
            else
            {
                bool bothExploded=false;
                while(i<ast.size() && ast[i]<0 && ans.size()>0 && ans.back()>0 && abs(ast[i])>=ans.back())
                {
                    if(abs(ast[i])==ans.back())
                    {
                        bothExploded=true;
                        ans.pop_back();
                        break;
                    }
                    ans.pop_back();
                }          
                if((ans.size()==0 || (ans.size()>0 && ans.back()<0)) && bothExploded==false)
                ans.push_back(ast[i]);
            }
            i++;
        }
        return ans;
    }
};
class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) 
    {
        vector<int> ans;
        for(int i=0;i<asteroids.size();i++)
        {
            // positive element encountered then simply add it to the ans.
            if(asteroids[i]>0)                    
            ans.push_back(asteroids[i]);
            
            else
            {
                while(!ans.empty() && ans.back()>0 && ans.back()<abs(asteroids[i]))
                ans.pop_back();

                if(!ans.empty() && ans.back()==abs(asteroids[i]))
                {
                    ans.pop_back();
                    continue;
                }

                if(ans.empty() || ans.back()<0)
                ans.push_back(asteroids[i]);
            }
        }
        return ans;
    }

    // dry run on the below examples to get more clarity about the working of the above code.
    // asteroids = [-2,-1,2,5]
    // asteroids = [-2,3,-4,5,-8,6,-4]
    // asteroids = [2,-2,4,5,-8]
    // asteroids = [8,2,4,-4,-2,8]
};
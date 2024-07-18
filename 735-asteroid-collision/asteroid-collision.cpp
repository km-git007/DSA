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
            
            // negative element encountered
            else                            
            {
                // to keep track of blast. For example asteroids=[10,-10]
                bool blast=false;           

                // keep popping till you either empty the ans or you keep encountering a positive element at the   
                // back of the the ans having value lesss then the abs value of the current negative element.
                while(!ans.empty() && ans.back()>0 && ans.back()<=abs(asteroids[i]))
                {
                    if(ans.back()==abs(asteroids[i]))
                    {
                        blast=true;
                        ans.pop_back();
                        break;
                    }
                    ans.pop_back();
                }
                
                // add the current negative element to the ans if the ans is empty or you've encountered a 
                // negative element at the back of the the ans and no blast has occured.
                // again the same example --> asteroids=[10,-10]
                // for above example even after the ans being empty '-10' won't be added to the ans.
                if((ans.empty() || ans.back()<0) && !blast)
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
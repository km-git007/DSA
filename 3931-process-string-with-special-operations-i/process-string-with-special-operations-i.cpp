class Solution {
public:
    string processStr(string s) {
        

        string r="";
        for(int i=0;i<s.length();i++)
        {

            if(s[i]>='a' && s[i]<='z')
            {
                 r+=s[i];
            }
            else if(s[i] == '*' && r.length()>0)
            {
                r.pop_back();
            }
             else if(s[i]=='#')
            {
                r+=r;
            }
             else if(s[i]=='%')
            {
               reverse(r.begin(),r.end());
            }
        }
        return r;
    }

};
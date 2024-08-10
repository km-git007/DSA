class Solution {
public:
    string decodeMessage(string key, string message) 
    {
        int myChar='a';
        unordered_map<char,char> map;
        for(char c : key)
        {
            if(c==' ' || map[c]!=0)
            continue;
            
            map[c]=myChar;
            myChar++;
        }

        for(int i=0;i<message.length();i++)
        {
            if(message[i]==' ')
            continue;
            message[i]=map[message[i]];
        }
        return message;
    }
};
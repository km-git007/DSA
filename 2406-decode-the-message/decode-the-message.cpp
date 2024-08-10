class Solution {
public:
    string decodeMessage(string key, string message) {
        ios::sync_with_stdio(0);
        cin.tie(0);
        unordered_map<char,char> m;
        char a='a';
        for(int i=0;i<key.size();i++){
            if(key[i]!=' ' && m.find(key[i])==m.end()){
                m[key[i]]=a;
                a++;
            }
        }m[' ']=' ';
        string s="";
        for(int i=0;i<message.size();i++){
            s+=m[message[i]];
        }return s;
    }
};
class Solution {
public:
    class DSU {
    public:

        vector<int> parent, rank;
        DSU(int n)
        {
            for(int i = 0; i < n; i++)
            {
                parent.push_back(i);
                rank.push_back(0);
            }
        }

        int find(int x) 
        {
            if(x == parent[x])
            return x;
            
            // Path compression
            return parent[x] = find(parent[x]);
        }

        void unionSet(int x, int y) 
        {
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY)
            return;

            // Union by rank
            // rank same - anyone can be made parent
            if(rank[parentX] == rank[parentY]) 
            {
                parent[parentX] = parentY;
                rank[parentY]++;
            }

            // rank of parent of 'x' is higher
            else if(rank[parentX] > rank[parentY])
            parent[parentY] = parentX;

            // rank of parent of 'y' is higher
            else
            parent[parentX] = parentY;

        }
    };

    vector<vector<string>> accountsMerge(vector<vector<string>>& acc) 
    {
        int n = acc.size();
        DSU* dsu = new DSU(n);
        unordered_map<string, int> map;

        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < acc[i].size(); j++)
            {
                if(!map.count(acc[i][j]))
                map[acc[i][j]] = i;
                else
                dsu->unionSet(map[acc[i][j]], i);
            }
        }

        vector<vector<string>> mergedMail(n);
        for(auto it : map)
        {
            string mail = it.first;
            // find the parent node
            int index = dsu->find(it.second);

            // add the mail
            mergedMail[index].push_back(mail);
        }

        vector<vector<string>> res;
        for(int i = 0; i < n; i++)
        {
            if(mergedMail[i].empty())
            continue;

            // sort the merged mails
            sort(mergedMail[i].begin(), mergedMail[i].end());

            // create a temp vector to store username followed by the mails
            vector<string> temp;
            // add the username
            temp.push_back(acc[i][0]);

            // add all the mails from the mergedMails
            for(auto mail : mergedMail[i])
            temp.push_back(mail);

            // add the temp ans into the result
            res.push_back(temp);
        }

        return res;
    }
};
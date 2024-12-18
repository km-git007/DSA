class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) 
    {
        queue<int> q;
        for(int i = 0; i < tickets.size(); i++)
        q.push(i == k ? -tickets[i] : tickets[i]);

        int time = 0;
        while(!q.empty())
        {
            int ticket = q.front();
            q.pop();

            if(ticket == -1)
            return time + 1;

            ticket = ticket < 0 ? ++ticket : --ticket;
            if(ticket != 0)
            q.push(ticket);
            time++;      
        }
        return -1;
    }
};
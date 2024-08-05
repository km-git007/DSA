class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) 
    {
        int n=students.size();
        stack<int>stack;
        for(int i=n-1;i>=0;i--)
        stack.push(sandwiches[i]);

        deque<int> line;
        for(int i=0;i<n;i++)
        {
            if(students[i]==stack.top())
            stack.pop();
            else
            line.push_back(students[i]);
        }

        while(!line.empty())
        {
            int Size=line.size();
            for(int stud : line)
            {
                if(stud==stack.top())
                {
                    stack.pop();
                    line.pop_front();
                }
                else
                {
                    line.pop_front();
                    line.push_back(stud);
                }
            }
            if(Size==line.size())
            return Size;
        }
        return 0;
    }
};
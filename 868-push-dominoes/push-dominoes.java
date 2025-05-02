class Solution {
    public String pushDominoes(String dom) 
    {
        int N = dom.length();
        int [] forces = new int[N];
        
        int force = 0;
        for(int i = N - 1; i >= 0; i--)
        {
            char ch = dom.charAt(i);
            if(ch == 'L')
            force = N;

            else if(ch == '.')
            force = Math.max(0, force - 1);

            else
            force = 0;

            forces[i] -= force;
        }

        force = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
        {
            char ch = dom.charAt(i);
            if(ch == 'R')
            force = N;

            else if(ch == '.')
            force = Math.max(0, force - 1); // dominoes = "......"

            else
            force = 0;

            forces[i] += force;

            char c = forces[i] > 0 ? 'R' : (forces[i] < 0 ? 'L' : '.');
            sb.append(c);
        }

        return sb.toString();
    }
}
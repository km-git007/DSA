class Solution {
    public String rankTeams(String[] votes) 
    {
        int n = votes[0].length(); // number of teams / ranks
        int[][] voteCount = new int[26][n];

        for (String vote : votes)
        {
            for(int i = 0; i < n; i++)
            {
                char ch = vote.charAt(i);
                voteCount[ch - 'A'][i]++; 
            }
        }

        List<Character> teamList = new ArrayList<>();
        for(char ch : votes[0].toCharArray()) 
        teamList.add(ch);

        Collections.sort(teamList, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if(voteCount[a - 'A'][i] != voteCount[b - 'A'][i])
                return voteCount[b - 'A'][i] - voteCount[a - 'A'][i];
            }
            return a - b; // Alphabetical order if tie
        });

        StringBuilder sb = new StringBuilder();
        for (char ch : teamList) 
        sb.append(ch);
        
        return sb.toString();
    }
}
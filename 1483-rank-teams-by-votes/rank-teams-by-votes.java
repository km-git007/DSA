class Solution {
    public String rankTeams(String[] votes) 
    {
        Set<Character> charSet = new HashSet<>();
        int [][] voteCount = new int[26][26];
        for(String vote : votes)
        {
            for(int i = 0; i < vote.length(); i++)
            {
                char ch = vote.charAt(i);
                charSet.add(ch);
                voteCount[ch - 'A'][i]++; 
            }
        }

        Queue<Character> pq = new PriorityQueue<>((a, b) -> {
            for(int i = 0; i < 26; i++)
            {
                if(voteCount[a - 'A'][i] != voteCount[b - 'A'][i])
                return voteCount[b - 'A'][i] - voteCount[a - 'A'][i];
            }
            return a - b;
        });

        for(Character ch : charSet)
        pq.add(ch);

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        sb.append(pq.poll());

        return sb.toString();
    }
}
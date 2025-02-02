class Solution {
    private char[] letters = {'A', 'C', 'G', 'T'};
    public int minMutation(String startGene, String endGene, String[] bank) 
    {
        Set<String> set = new HashSet<>();
        for(String gene : bank)
        set.add(gene);

        set.remove(startGene);

        // If the end gene is not in the bank, return -1 immediately
        if(!set.contains(endGene)) 
        return -1;

        int mutations = 0;
        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        while(!q.isEmpty())
        {
            int level = q.size();
            for(int i = 0;i <level; i++)
            {
                String curr = q.poll();

                if(curr.equals(endGene))
                return mutations;

                StringBuilder sb = new StringBuilder(curr);
                for(int j = 0; j < 8; j++)
                {
                    char ch = sb.charAt(j);
                    for(char letter : letters)
                    {
                        sb.setCharAt(j, letter);
                        String nextMutation = sb.toString();
                        if(set.contains(nextMutation))
                        {
                            q.add(nextMutation);
                            // Mark as visited by removing it from the set
                            set.remove(nextMutation); 
                        }
                    }
                    // Restore original character
                    sb.setCharAt(j, ch);
                }
            }
            mutations++;
        }
        return -1;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) 
    {
        Set<String> set = new HashSet<>();
        for(var deadend : deadends)
        set.add(deadend);

        if(set.contains("0000"))
        return -1;

        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add("0000");

        int turns = 0;
        while(!bfsQueue.isEmpty())
        {
            int level = bfsQueue.size();
            for(int i = 0; i < level; i++)
            {
                String curr = bfsQueue.poll();

                if(curr.equals(target))
                return turns;

                for(int j = 0; j < 4; j++)
                {
                    char ch = curr.charAt(j);

                    char prevChar = (char) (((ch - '0' + 9) % 10) + '0');
                    char nextChar = (char) (((ch - '0' + 1) % 10) + '0');

                    StringBuilder prev = new StringBuilder(curr);
                    prev.setCharAt(j, prevChar);
                    String prevComb = prev.toString();
                    if(!set.contains(prevComb))
                    {
                        bfsQueue.add(prevComb);
                        set.add(prevComb);
                    }

                    StringBuilder next = new StringBuilder(curr);
                    next.setCharAt(j, nextChar);
                    String nextComb = next.toString();
                    if(!set.contains(nextComb))
                    {
                        bfsQueue.add(nextComb);
                        set.add(nextComb);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}
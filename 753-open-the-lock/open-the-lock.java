class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        if(deadendsSet.contains("0000")){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int minimumTurns = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                String curr = queue.poll();
                if(curr.equals(target)){
                    return minimumTurns;
                }

                StringBuilder sb = new StringBuilder(curr);
                for(int j = 0; j < 4; j++){
                    char ch = sb.charAt(j);

                    char prevChar = (char) (((ch - '0' + 9) % 10) + '0');
                    sb.setCharAt(j, prevChar);
                    String prev = sb.toString();
                    if(!deadendsSet.contains(prev)){
                        queue.offer(prev);
                        deadendsSet.add(prev);
                    }

                    char nextChar = (char) (((ch - '0' + 1) % 10) + '0');
                    sb.setCharAt(j, nextChar);
                    String next = sb.toString();
                    if(!deadendsSet.contains(next)){
                        queue.offer(next);
                        deadendsSet.add(next);
                    }
                    // undo
                    sb.setCharAt(j, ch);
                }
            }
            minimumTurns++;
        }
        return -1;
    }
}
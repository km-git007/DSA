class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000")) {
            return -1;
        }

        int turnCount = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                String curr = queue.poll();
                if(curr.equals(target)) {
                    return turnCount;
                }

                StringBuilder currCombination = new StringBuilder(curr);
                for(int index = 0; index < 4; index++) {
                    char original = currCombination.charAt(index);

                    char nextChar = (char) ((original - '0' + 1) % 10 + '0');
                    currCombination.setCharAt(index, nextChar);
                    String nextCombination = currCombination.toString();

                    if(!deadSet.contains(nextCombination)) {
                        queue.add(nextCombination);
                        deadSet.add(nextCombination);
                    }

                    char prevChar = (char) ((original - '0' + 9) % 10 + '0');
                    currCombination.setCharAt(index, prevChar);
                    nextCombination  = currCombination.toString();

                    if(!deadSet.contains(nextCombination)) {
                        queue.add(nextCombination);
                        deadSet.add(nextCombination);
                    }

                    // undo
                    currCombination.setCharAt(index, original);
                }
            }
            turnCount++;
        }

        return -1;
    }
}
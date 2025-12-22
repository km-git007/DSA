class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if(!geneBank.contains(endGene)) {
            return -1;
        }

        char[] mutations = {'A','C','G','T'};

        int mutationCount = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                String gene = queue.poll();
                if(gene.equals(endGene)) {
                    return mutationCount;
                }

                StringBuilder currGene = new StringBuilder(gene);
                for(int index = 0; index < currGene.length(); index++) {
                    char original = currGene.charAt(index);
                    for(char mutation : mutations) {
                        currGene.setCharAt(index, mutation);
                        String nextGene = currGene.toString();
                        if(geneBank.contains(nextGene)) {
                            queue.add(nextGene);
                            geneBank.remove(nextGene);
                        }
                    }
                    currGene.setCharAt(index, original);
                }
            }
            mutationCount++;
        }

        return -1;
    }
}
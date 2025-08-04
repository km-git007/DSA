class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if(!geneBank.contains(endGene)){
            return -1;
        }
        
        char[] mutations = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        int minimumMutation = 0;
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                String gene = queue.poll();
                if(gene.equals(endGene)){
                    return minimumMutation;
                }
                
                StringBuilder currentGene = new StringBuilder(gene);
                for(int j = 0; j < currentGene.length(); j++){
                    char ch = currentGene.charAt(j);
                    for (char mutation : mutations){
                        currentGene.setCharAt(j, mutation);
                        String mutatedGene = currentGene.toString();
                        if(geneBank.contains(mutatedGene)){
                            queue.add(mutatedGene);
                            geneBank.remove(mutatedGene);
                        }
                        currentGene.setCharAt(j, ch);
                    }
                }
            }
            minimumMutation++;
        }
        return -1;
    }
}
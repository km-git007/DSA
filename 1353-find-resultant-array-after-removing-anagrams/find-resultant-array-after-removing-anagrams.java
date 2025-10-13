class Solution {
    private void processWord(int[] map, String word){
        for(char ch : word.toCharArray()){
            map[ch - 'a']++;
        }
    }

    private boolean isAnagram(int[] map1, int[] map2){
        for(int i = 0; i < 28; i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);

        int[] prev = new int[28];
        processWord(prev, words[0]);

        for(int i = 1; i < words.length; i++){
            int[] curr = new int[28];
            processWord(curr, words[i]);
            if(!isAnagram(prev, curr)){
                prev = curr;
                res.add(words[i]);
            }
        }
        return res;
    }
}
class Solution {
    public String frequencySort(String s) {
        // Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Bucket sort by frequency
        List<Character>[] buckets = new List[s.length() + 1];
        for(char ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }
        
        // Build result from highest frequency to lowest
        StringBuilder sb = new StringBuilder();
        for(int freq = buckets.length - 1; freq >= 0; freq--) {
            if(buckets[freq] != null) {
                for(char ch : buckets[freq]) {
                    for(int i = 0; i < freq; i++) {
                        sb.append(ch);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}

class Solution {
    public String frequencySort(String s) {
                // Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Sort by frequency in descending order
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        
        // Build result
        StringBuilder sb = new StringBuilder();
        for(char ch : chars) {
            int freq = freqMap.get(ch);
            for(int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
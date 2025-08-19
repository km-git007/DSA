class Solution {
    public String frequencySort(String s) {
        // Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            int frequency = freqMap.get(c);
            while(frequency > 0){
                sb.append(c);
                frequency--;
            }
        }
        return sb.toString();
    }
}
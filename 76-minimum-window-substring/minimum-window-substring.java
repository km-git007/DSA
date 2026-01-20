class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size(), minLength = s.length();
        int startIndex = -1, i = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) == 0){
                count--;
            }

            while(count == 0){
                if(j - i + 1 <= minLength){
                    startIndex = i;
                    minLength = Math.min(minLength, j - i + 1);
                }

                c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == 1){
                    count++;
                }

                i++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
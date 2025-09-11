class Solution {
    // Returns true if the character is a vowel.
    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i' 
            || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
    
    public String sortVowels(String s){
        Map<Character, Integer> map = new HashMap<>();
        // Store the vowels count in map.
        for(char c : s.toCharArray()){
            if(isVowel(c))
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sorted string having all the vowels.
        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            // If the character is a vowel, replace it with the character in the string temp.
            if(isVowel(s.charAt(i))){
                while(j < sortedVowel.length() && !map.containsKey(sortedVowel.charAt(j))){
                    j++;
                }

                // if(j >= sortedVowel.length()){
                //     continue;
                // }

                char ch = sortedVowel.charAt(j);
                ans.append(ch);
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 0){
                    map.remove(ch);
                    j++;
                }
            } else {
                ans.append(s.charAt(i));
            }
        }
        
        return ans.toString();
    }
};
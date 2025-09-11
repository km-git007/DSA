class Solution {

    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = 0;

        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
        while(i < s.length() && j < s.length()){
            while(i < s.length() && !vowels.contains(sb.charAt(i))){
                i++;
            }

            while(j < s.length() && !vowels.contains(arr[j])){
                j++;
            }

            if(i < s.length() && j < s.length()){
                sb.setCharAt(i, arr[j]);
                i++; j++;
            }
        }
        return sb.toString();
    }
}
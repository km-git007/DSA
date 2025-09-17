class Solution {
    private String getKey(String email) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (email.charAt(i) != '@'){
            if (email.charAt(i) == '.') {
                i++;
            } else if (email.charAt(i) == '+') {
                break;
            }else{
                sb.append(email.charAt(i));
                i++;
            }
        }
        
        while (email.charAt(i) != '@') {
            i++;
        }
        
        while (i < email.length()) {
            sb.append(email.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails) {
            String key = getKey(email);
            emailSet.add(key);
        }
        return emailSet.size();
    }
}
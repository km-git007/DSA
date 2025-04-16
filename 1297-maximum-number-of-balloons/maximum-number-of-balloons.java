class Solution {
    public int maxNumberOfBalloons(String text) 
    {
        Set<Character> set = Set.of('b', 'a', 'l', 'o', 'n');
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : text.toCharArray())
        {
            if(set.contains(ch))
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // text = "lloo", "balloo", "allnnn"
        if(map.size() < 5)
        return 0;

        int instances = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) 
        {
            char key = entry.getKey();
            int value = (key == 'l' || key == 'o') ? entry.getValue() / 2 : entry.getValue();

            instances = Math.min(instances, value);
        }
        return instances;
    }
}
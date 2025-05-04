class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = Math.min(x, y);
        this.y = Math.max(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair other = (Pair) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution 
{
    public int numEquivDominoPairs(int[][] dominoes) 
    {
        int count = 0;
        Map<Pair, Integer> map = new HashMap<>();
        for (int[] dom : dominoes) 
        {
            Pair p = new Pair(dom[0], dom[1]);
            int freq = map.getOrDefault(p, 0);
            count += freq;
            map.put(p, freq + 1);
        }
        return count;
    }
}
class Pair{
    String str;
    double val;
    public Pair(String str, double val){
        this.str = str;
        this.val = val;
    }
}

class Solution {
    private Map<String, List<Pair>> buildGraph(List<List<String>> equations, double[] values){
        int n = equations.size();
        Map<String, List<Pair>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            var equation = equations.get(i);
            String x = equation.getFirst();
            String y = equation.getLast();

            adj.putIfAbsent(x, new ArrayList<>());
            adj.putIfAbsent(y, new ArrayList<>());
            adj.get(x).add(new Pair(y, values[i]));
            adj.get(y).add(new Pair(x, 1.0 / values[i]));
        }
        return adj;
    }

    private double bfs(String start, String end, Map<String, List<Pair>> adj){
        if(!adj.containsKey(start)){
            return -1;
        }
        
        if(start.equals(end)){
            return 1.0;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair(start, 1.0));
        visited.add(start);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            String node = pair.str;
            double nodeVal = pair.val;
            
            if(node.equals(end)){
                return nodeVal;
            }
            
            if(!adj.containsKey(node)){
                continue;
            }

            for(Pair nbr : adj.get(node)){
                if(!visited.contains(nbr.str)){
                    queue.add(new Pair(nbr.str, nodeVal * nbr.val));
                    visited.add(nbr.str);
                }
            }
        }
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        var adj = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        int index = 0;
        for(var query : queries){
            String start = query.getFirst();
            String end = query.getLast();
            res[index++] = bfs(start, end, adj);
        }
        return res;
    }
}
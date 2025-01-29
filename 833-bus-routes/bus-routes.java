class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) 
    {
        if(source == target)
        return 0;

        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < routes[i].length; j++)
            {
                if(!map.containsKey(routes[i][j]))
                map.put(routes[i][j], new ArrayList<>());

                map.get(routes[i][j]).add(i);
            }
        }

        if(map.get(source) == null)
        return -1;

        // for stop numbers
        Queue<Integer> q = new LinkedList<>();

        Set<Integer> visBus = new HashSet<>();
        Set<Integer> visStop = new HashSet<>();

        var busesOnSource = map.get(source);
        for(int bus : busesOnSource)
        {
            visBus.add(bus);
            for(int stop : routes[bus])
            {
                visStop.add(stop);
                q.add(stop);
            }
        }

        int busTaken = 1;
        while(!q.isEmpty())
        {
            int level = q.size();
            for(int i = 0; i < level; i++)
            {
                int currStop = q.poll();

                if(currStop == target)
                return busTaken;

                for(int bus : map.get(currStop))
                {
                    if(!visBus.contains(bus))
                    {
                        visBus.add(bus);
                        for(int stop : routes[bus])
                        {
                            if(!visStop.contains(stop))
                            {
                                q.add(stop);
                                visStop.add(stop);
                            }
                        }
                    }
                }
            }
            busTaken++;
        }
        // no bus route exists from source to target
        return -1;
    }
}
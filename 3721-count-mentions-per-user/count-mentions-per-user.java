class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numberOfUsers; i++) {
            map.put(i, 0);
        }

        events.sort((a, b) -> {
            int timeCompare = Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));
            if(timeCompare != 0) return timeCompare;
            // OFFLINE events should be processed before MESSAGE events at same timestamp
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });
        
        int[] count = new int[numberOfUsers];
        for(var event : events){
            String eventType = event.getFirst();
            String timestamp = event.get(1);
            String ids = event.getLast();

            if(eventType.equals("MESSAGE")){
                if(ids.equals("ALL")){
                    for(int i = 0; i < numberOfUsers; i++){
                        count[i]++;
                    }
                }else if(ids.equals("HERE")){
                    for(int i = 0; i < numberOfUsers; i++){
                        if(map.get(i) <= Integer.parseInt(timestamp)){
                            count[i]++;
                        }
                    }
                }
                else{
                    String[] idsArray = ids.split(" ");
                    for(String stringId : idsArray){
                        int id = Integer.parseInt(stringId.substring(2));
                        count[id]++;
                    }
                }
            }
            else{
                int id = Integer.parseInt(ids);
                map.put(id, Integer.parseInt(timestamp) + 60);
            }
        }
        return count;
    }
}
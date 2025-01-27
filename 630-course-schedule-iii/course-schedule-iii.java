class Solution {
    public int scheduleCourse(int[][] courses) 
    {
        //Sort the courses by their deadlines
        Arrays.sort(courses,(a,b) -> a[1]-b[1]); 

        // Create a heap 
        // largest duration stays on top
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int time = 0, count = 0;
        for(int[] course : courses)
        {
            int finishTime = course[1];
            int duration = course[0];

            // course can be completed
            if(time + duration <= finishTime)
            {
                pq.add(course[0]);
                time += duration;
            }

            // course can be completed with swap
            else if(!pq.isEmpty() && pq.peek() >= duration)
            {
                pq.add(course[0]);
                time = time - pq.poll() + duration;
            }
        }
        return pq.size();
    }
}
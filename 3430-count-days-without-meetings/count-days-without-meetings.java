class Solution {
    public int countDays(int days, int[][] meetings) 
    {
        // sort on basis of start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int count = 0;
        int endTime = 0;
        for(int[] meeting : meetings)
        {
            int meetingStartTime = meeting[0];
            int meetingEndTime = meeting[1];

            // Ignore meetings beyond the total number of days
            if(meetingStartTime > days)
            break;

            if(meetingStartTime > endTime)
            count += meetingStartTime - endTime - 1;

            endTime = Math.max(endTime, meetingEndTime);
        }

        // Account for remaining free days after the last meeting
        if(endTime < days)
        count += days - endTime;

        return count;
    }
}
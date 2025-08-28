class Event{
    int start, end;
    public Event(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {

    private List<Event> eventList;
    public MyCalendar() {
        eventList = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for(Event event : eventList){
            if(startTime < event.end && endTime > event.start){
                return false;
            }
        }
        eventList.add(new Event(startTime, endTime));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
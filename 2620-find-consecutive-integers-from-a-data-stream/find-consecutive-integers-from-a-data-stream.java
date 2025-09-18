class DataStream {
    private int value, k;
    private int streak;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.streak = 0;
    }

    public boolean consec(int num) {
        if (num == value) {
            streak++;
        } else {
            streak = 0;
        }
        return streak >= k;
    }
}

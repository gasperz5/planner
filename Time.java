public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getMinutes() {
        return hour * 60 + minute;
    }

    public String toString() {
        return hour + ":" + minute;
    }

    public void addMinutes(int minutes) {
        minute += minutes;
        hour += minute / 60;
        minute %= 60;
    }
}

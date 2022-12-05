public class FixedTask extends Task {

    private Time startTime;

    public FixedTask(String name, int durationMinutes, Time startTime) {
        super(name, durationMinutes);
        this.startTime = startTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime(){
        Time endTime = new Time(startTime.getHour(), startTime.getMinute());
        endTime.addMinutes(super.getDurationMinutes());
        return endTime;
    }

    public boolean isTimeForTask(Time time, Task task) {
        if (task == null) {
            return false;
        }
        return startTime.getMinutes() - time.getMinutes() >= task.getDurationMinutes();
    }

    public int nInTime(Time time, Task root) {
        int mins = 0;
        int c = -1;
        do {
            mins += root.getDurationMinutes();
            root = root.getNext();
            c++;
        } while (startTime.getMinutes() - time.getMinutes() >= mins && root != null);
        return c;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + startTime.toString() + "]";
    }

    @Override
    public FixedTask getNext(){
        return (FixedTask) super.getNext();
    }

}

public class Task {

    private Task next; 
    private String name;
    private int durationMinutes;

    public Task(String name, int durationMinutes) {
        this.name = name;
        this.durationMinutes = durationMinutes;
    }
    public Task(String name, int durationMinutes, Task next) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.next = next;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public Task deleteTask(){
        return next;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

}
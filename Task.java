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

    public String toString() {
        return name+" ("+durationMinutes+" min)";
    }

    public String getNTasks(int n) {
        if (next == null || n == 0) {
            return toString();
        }
        return toString() + ", " + next.getNTasks(n - 1);
    }

    public String getAllTasks() {
        return getNTasks(-1);
    }

    public Task deleteTask() {
        if (next == null) {
            return null;
        }
;
        next = next.getNext();
        name = next.getName();
        durationMinutes = next.getDurationMinutes();
        return this;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void addTask(Task task) {
        if (next == null) {
            next = task;
        } else {
            next.addTask(task);
        }
    }

}
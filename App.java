public class App {
    public static void main(String[] args) {

        Time curr = new Time(7, 5);

        Task root = new Task("root", 3);
        for (int i = 0; i < 10; i++) {
            String name = "Task" + i;
            int duration = i * 10+5;
            root.addTask(new Task(name, duration));
        }
        root.addTask(new Task("Task10", 100));
        System.out.println(root.getAllTasks());

        FixedTask rootF = new FixedTask("rootF", 20, new Time(8, 0));
        rootF.addTask(new FixedTask("FTask1", 10, new Time(10, 0)));
        System.out.println(rootF.getAllTasks());

        System.out.println(rootF.nInTime(curr, root));

        while (root != null && rootF != null) {
            if (rootF.isTimeForTask(curr, root)) {
                System.out.println(root.getName()+" "+curr.toString());
                curr.addMinutes(root.getDurationMinutes());
                root = root.getNext();
            } else {
                System.out.println(rootF.getName()+" "+rootF.getStartTime().toString());
                curr = rootF.getEndTime();
                rootF = rootF.getNext();
            }
        }
    }
}

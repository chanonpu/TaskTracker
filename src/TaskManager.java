import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TaskManager {

    private static final String TASK_FILE = "task.json";

    // save task to Json file
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TASK_FILE))) {
            for (Task task : tasks) {
                writer.write(task.toJson());
                writer.newLine(); // write each task as a json like string
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // load task from Json file
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TASK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromJson(line)); // read each line from json
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;

    }

    // add task
    public static void addTask(String description) {
        List<Task> tasks = loadTasks();
        Task task = new Task(description);
        tasks.add(task);
        saveTasks(tasks);
        System.out.println("Task added successfully (ID: " + task.getId() + " )");
    }

    // update task
    public static void updateTask(int id, TaskStatus status) {
        List<Task> tasks = loadTasks();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                saveTasks(tasks);
                System.out.println("Task marked as : " + status);
                return;
            }
        }
        System.out.println("No task founded");
    }

    // delete task
    public static void deleteTask(int id) {
        List<Task> tasks = loadTasks();
        tasks.removeIf(task -> task.getId() == id);
        saveTasks(tasks);
        System.out.println("Task deleted successfully");
    }

    // list all task
    public static void listTasks() {
        List<Task> tasks = loadTasks();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // list status task
    public static void listStatusTask(TaskStatus status) {
        List<Task> tasks = loadTasks();
        System.out.println("Task that are "+status+" : ");
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                System.out.println(task);
            }
        }
    }
}

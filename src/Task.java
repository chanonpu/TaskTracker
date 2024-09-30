import java.time.LocalDateTime;

public class Task {
    private int id;
    private String desc;
    private TaskStatus status;
    private String createdAt;
    private String updatedAt;

    // constructor
    public Task(int id, String desc) {
        this.id = id;
        this.desc = desc;
        status = TaskStatus.TODO;
        createdAt = LocalDateTime.now().toString();
        updatedAt = LocalDateTime.now().toString();
    }

    // convert task to json file

    public String toJson() {
        return "{" + "\"id\": " + id + "," +
                "\"description\": " + desc + "," +
                "\"status\": " + status + "," +
                "\"created_at\": " + createdAt + "," +
                "\"updated_at\": " + updatedAt + "}";
    }

    // convert json file to task
    public static Task fromJson(String json) {
        // parse json string to json object
        String[] parts = json.replace("}", "")
                .replace("{", "")
                .replace("\"", "")
                .split(",");

        int id = Integer.parseInt(parts[0].split(":")[1].trim()); // id:1234
        String desc = parts[1].split(":")[1].trim(); // description:abc
        TaskStatus status = TaskStatus.valueOf(parts[2].split(":")[1].trim().toUpperCase());
        String createdAt = parts[3].split(":")[1].trim();
        String updatedAt = parts[4].split(":")[1].trim();

        Task task = new Task(id, desc);
        task.status = status;
        task.createdAt = createdAt;
        task.updatedAt = updatedAt;

        return task;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now().toString();
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {

        return "{" + "\"id\": " + id + "," +
                "\"description\": " + desc + "," +
                "\"status\": " + status + "," +
                "\"created_at\": " + createdAt + "," +
                "\"updated_at\": " + updatedAt + "}";
    }

}

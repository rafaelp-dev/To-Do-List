package domain;

public class Task {
    private static int idCounter = 0;

    private int taskId;
    private String title;
    private String description;
    private String priority;
    private boolean status;

    public Task(String title, String description, String priority){
        this.taskId = idCounter ++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

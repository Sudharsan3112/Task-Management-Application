package OOPs;

import java.util.Date;

public class Task {
    final private int id;
    private String taskname;
    private String description;
    Date date;

    public Task(int id, String taskname, String description, Date date) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

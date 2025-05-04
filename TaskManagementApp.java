package OOPs;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TaskManagementApp {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner z=new Scanner(System.in);
        int id=1;
        TaskManager taskManager=new TaskManager();
        boolean app=true;
        taskManager.readInFile();
        id=taskManager.tasks.size();
        while (app) {
            System.out.println("Welcome to your Personalized Task Manager !\n" +
                    " 1. Create your new Task\n "+"2. Remove Particular Task\n " +
                    "3. View your existing Task\n " +
                    "4. Exit");
            int choice = z.nextInt();
            switch (choice) {
                case 1: {

                    z.nextLine();
                    System.out.println("Enter your Task name:");
                    String taskname = z.nextLine();
                    System.out.println("Enter your Task Description:");
                    String taskdesc = z.nextLine();
                    Date date = null;
                    while (date == null) {
                        System.out.println("Enter your Task Due Date in format(dd-MM-yyyy):");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String taskdate = z.next();
                        try {
                            Date d = dateFormat.parse(taskdate);
                            System.out.println(d);
                            date = d;
                            System.out.println(date);
                        } catch (Exception e) {
                            System.out.println("Enter your Task Due Date in correct format(dd-MM-yyyy)!!");
                        }
                    }
                    Task task = new Task(id++, taskname, taskdesc, date);
                    taskManager.addTask(task);
                    break;
                }
                case 2: {
                    System.out.println("Enter the id of the task to remove:");
                    int taskid = z.nextInt();
                    taskManager.removeTask(taskid);
                    break;
                }
                case 3: {
                    System.out.println("List of Tasks in your TaskManager:");
                    taskManager.display();
                    break;
                }
                case 4:
                    taskManager.writeInFile();
                    System.out.println("Have a Nice Day!!");
                    app=false;
            }
        }
    }
}

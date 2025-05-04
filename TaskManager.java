package OOPs;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    List<Task>tasks=new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    void addTask(Task task)
    {
        tasks.add(task);
        Collections.sort(tasks,(a,b)->a.getDate().compareTo(b.getDate()));
    }
    void removeTask(int id)
    {
        tasks.removeIf(task -> task.getId()==id);
    }
    void display()
    {
        for(Task task:tasks)
        {
            System.out.println(printTask(task));
        }
    }
    String printTask(Task task)
    {
        return "Task Id: "+task.getId()+"|"+
                "Task Name: "+task.getTaskname()+"|"+
                "Task Description: "+task.getDescription()+"|"+
                "Task Due Date: "+getDateinFormat(task.getDate());
    }
    void writeInFile() throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("C:\\\\Users\\\\sudha\\\\OneDrive\\\\Desktop\\\\Task.txt"));
        for (Task task:tasks)
        {
            String s=task.getId()+" "+task.getTaskname()+" "+task.getDescription()+" "+sdf.format(task.getDate());
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    void readInFile() throws IOException, ParseException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\\\Users\\\\sudha\\\\OneDrive\\\\Desktop\\\\Task.txt"));
        String line;
        while ((line=bufferedReader.readLine())!=null)
        {
            String s[]=line.split(" ");
            int idd=Integer.parseInt(s[0]);
            Date date = sdf.parse(s[3]);
            Task task=new Task(idd,s[1],s[2],date);
            System.out.println(line);
        }
    }
    String getDateinFormat(Date date)
    {
        SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
}

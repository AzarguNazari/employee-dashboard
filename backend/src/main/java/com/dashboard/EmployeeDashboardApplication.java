package com.dashboard;

import com.dashboard.model.Priority;
import com.dashboard.model.Status;
import com.dashboard.model.Task;
import com.dashboard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeDashboardApplication implements ApplicationRunner {

    @Autowired
    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDashboardApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        generateTasks().forEach(taskRepository::save);
    }

    public List<Task> generateTasks(){
        Task task1 = new Task();
        task1.setPercentage(50);
        task1.setPriority(Priority.NORMAL);
        task1.setStatus(Status.DONE);
        task1.setDescription("clean all unused branches");
        task1.setTaskname("Git Branch Cleaning");

        Task task2 = new Task();
        task2.setPercentage(10);
        task2.setPriority(Priority.HIGH);
        task2.setStatus(Status.NOT_READY);
        task2.setDescription("Create new branch for ticket 11");
        task2.setTaskname("Ticket Creation");

        Task task3 = new Task();
        task3.setPercentage(20);
        task3.setPriority(Priority.LOW);
        task3.setStatus(Status.NOT_READY);
        task3.setDescription("clean all unused branches");
        task3.setTaskname("Ticket Creation");

        Task task4 = new Task();
        task4.setPercentage(30);
        task4.setPriority(Priority.HIGH);
        task4.setStatus(Status.READY);
        task4.setDescription("discuss with team members about ticket 1");
        task4.setTaskname("Discussion about Ticket 1");

        return Arrays.asList(task1, task2, task3, task4);
    }
}

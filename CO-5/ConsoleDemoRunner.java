package com.example.student_management;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Runs automatically on startup and prints a full CRUD demo to the console,
 * so you see output directly in the VS Code terminal.
 */
@Component
public class ConsoleDemoRunner implements CommandLineRunner {

    private final StudentRepository repo;

    public ConsoleDemoRunner(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.deleteAll(); // start clean so output is the same on every run

        System.out.println("\n========== STUDENT MANAGEMENT : CRUD DEMO ==========");

        // CREATE
        System.out.println("\n[CREATE] Inserting 3 students...");
        repo.save(new Student("Ravi Kumar", "ravi@example.com", "B.Tech CSE", 20));
        repo.save(new Student("Anita Sharma", "anita@example.com", "B.Tech IT", 21));
        Student third = repo.save(new Student("John David", "john@example.com", "MCA", 23));
        printAll();

        // UPDATE
        System.out.println("\n[UPDATE] Changing course of '" + third.getName() + "' to 'MBA'...");
        third.setCourse("MBA");
        repo.save(third);
        printAll();

        // DELETE
        System.out.println("\n[DELETE] Removing student with ID " + third.getId() + "...");
        repo.deleteById(third.getId());
        printAll();

        System.out.println("\nTotal students in DB: " + repo.count());
        System.out.println("====================================================");
        System.out.println("Web UI is also running at: http://localhost:8080/\n");
    }

    private void printAll() {
        List<Student> students = repo.findAll();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-22s %-12s %-4s%n", "ID", "NAME", "EMAIL", "COURSE", "AGE");
        System.out.println("--------------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-4d %-15s %-22s %-12s %-4d%n",
                    s.getId(), s.getName(), s.getEmail(), s.getCourse(), s.getAge());
        }
        System.out.println("--------------------------------------------------------------------");
    }
}

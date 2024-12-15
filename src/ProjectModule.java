package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.Scanner;

public class ProjectModule {
    public static void showMenu() {
        while (true) {
            System.out.println("\nProject Manager Module");
            System.out.println("1. Check Performance of Developers and Testers");
            System.out.println("2. Monitor Bugs");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> checkPerformance();
                case 2 -> monitorBugs();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void checkPerformance() {
        System.out.println("Performance analysis is simulated here. Actual implementation depends on project-specific metrics.");
    }

    private static void monitorBugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            System.out.println("\nOpen and Closed Bugs:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading bugs.");
        }
    }
}
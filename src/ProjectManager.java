package bug_tracking;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.Scanner;

class ProjectManager extends User{
    public ProjectManager(String username, String password) {
        super(username, password, "Project Manager");
    }


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

    /**
     * <p>
     * @Override public void displayDashboard() is important, 
     * as this Class is inherited from (extends) User Abstract Class. 
     * </p>
     */
    @Override
    public void displayDashboard() {
        System.out.println("Welcome, Admin! Here you can report and monitor bugs.");
        // You can expand this with GUI or options.
    }
}
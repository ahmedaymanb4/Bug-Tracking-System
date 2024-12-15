package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.*;

public class TesterModule {

    // Function to show the Tester module menu
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTester Module");
            System.out.println("1. Add a Bug");
            System.out.println("2. View Bugs");
            System.out.println("3. Change Bug Status");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBug();
                    break;
                case 2:
                    viewBugs();
                    break;
                case 3:
                    changeBugStatus();
                    break;
                case 4:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Function to add a new bug
    private static void addBug() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bug name: ");
        String name = scanner.nextLine();

        System.out.print("Enter bug type: ");
        String type = scanner.nextLine();

        System.out.print("Enter bug priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        System.out.print("Enter bug level (Low, Medium, High): ");
        String level = scanner.nextLine();

        System.out.print("Enter project name: ");
        String projectName = scanner.nextLine();

        System.out.print("Enter bug status (Open, Closed): ");
        String status = scanner.nextLine();

        System.out.print("Enter screenshot path (if any, or leave empty): ");
        String screenshotPath = scanner.nextLine();

        System.out.print("Enter developer name to assign (or leave empty to skip): ");
        String developerAssigned = scanner.nextLine();

        Bug newBug = new Bug(name, type, priority, level, projectName, status, screenshotPath, developerAssigned);
        saveBugToFile(newBug);
        System.out.println("Bug added successfully!");
    }

    // Function to view all bugs
    private static void viewBugs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            System.out.println("\n--- List of Bugs ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading bugs.");
        }
    }

    // Function to change the status of a bug
    private static void changeBugStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the bug to change status: ");
        String bugName = scanner.nextLine();

        List<Bug> bugs = loadBugsFromFile();

        boolean bugFound = false;
        for (Bug bug : bugs) {
            if (bug.getName().equalsIgnoreCase(bugName)) {
                bugFound = true;
                System.out.print("Enter new status (Open, Closed): ");
                String newStatus = scanner.nextLine();
                bug.setStatus(newStatus);
                saveAllBugsToFile(bugs);
                System.out.println("Bug status updated successfully!");
                break;
            }
        }

        if (!bugFound) {
            System.out.println("Bug not found.");
        }
    }

    // Function to load all bugs from the file
    private static List<Bug> loadBugsFromFile() {
        List<Bug> bugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming Bug's toString method will give a readable format for bug details
                bugs.add(Bug.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading bugs.");
        }
        return bugs;
    }

    // Function to save a new bug to the file
    private static void saveBugToFile(Bug bug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bugs.txt", true))) {
            writer.write(bug.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving bug.");
        }
    }

    // Function to save all bugs to the file after updating status
    private static void saveAllBugsToFile(List<Bug> bugs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bugs.txt"))) {
            for (Bug bug : bugs) {
                writer.write(bug.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving bugs.");
        }
    }
}
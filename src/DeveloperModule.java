package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.io.*;
import java.util.*;

public class DeveloperModule {

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDeveloper Module");
            System.out.println("1. View Assigned Bugs");
            System.out.println("2. Change Bug Status");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAssignedBugs(scanner);  
                    break;
                case 2:
                    changeBugStatus(scanner);  
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewAssignedBugs(Scanner scanner) {
        System.out.print("Enter your name to view your assigned bugs: ");
        String developerName = scanner.nextLine();

        List<Bug> bugs = loadBugsFromFile(); 
        boolean bugFound = false;  
        System.out.println("\n--- Assigned Bugs ---");
        for (Bug bug : bugs) {
            
            if (bug.getDeveloperAssigned() != null && bug.getDeveloperAssigned().equalsIgnoreCase(developerName)) {
                System.out.println(bug);  
                bugFound = true;
            }
        }

        if (!bugFound) {
            System.out.println("No assigned bugs found.");
        }
    }

    private static void changeBugStatus(Scanner scanner) {
    System.out.print("Enter Bug Name to Change Status: ");
    String bugName = scanner.nextLine();
    System.out.print("Enter New Status (Open/Closed): ");
    String newStatus = scanner.nextLine();

    File inputFile = new File("bugs.txt");
    File tempFile = new File("temp.txt");

    boolean found = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;

        while ((line = reader.readLine()) != null) {
            
            if (line.contains("Name='" + bugName + "'")) {
                line = line.replaceFirst("Status='.*?'", "Status='" + newStatus + "'");
                found = true;
            }
            writer.write(line + "\n");
        }

        if (found) {
            System.out.println("Bug status updated successfully.");
        } else {
            System.out.println("Bug not found.");
        }

    } catch (IOException e) {
        System.out.println("Error updating bug status: " + e.getMessage());
    }

    if (inputFile.delete()) {
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Failed to rename temp file to bugs.txt");
        }
    } else {
        System.out.println("Failed to delete original file.");
    }
}

    private static List<Bug> loadBugsFromFile() {
    List<Bug> bugs = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("bugs.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Bug bug = Bug.fromString(line);
            if (bug != null) { 
                bugs.add(bug);
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading bugs.");
    }
    return bugs;
}
}
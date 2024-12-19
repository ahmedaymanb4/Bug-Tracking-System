package bugtrackingsystem;

/**
 *
 * @author Ahmed Ayman, Amr Khaled, Alaa Mohamed, Atef Khaled, Abdulmalek Mohamed
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class BugTrackingSystem {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        loadUsers();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBug Tracking System");
            System.out.println("1. Tester Module");
            System.out.println("2. Developer Module");
            System.out.println("3. Admin Module");
            System.out.println("4. Project Manager Module");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
                    

            switch (choice) {
                case 1 -> TesterModule.showMenu();
                case 2 -> {
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    DeveloperModule.showMenu(username);
                }
                case 3 -> AdminModule.showMenu();
                case 4 -> ProjectModule.showMenu();
                case 5 -> {
                    System.out.println("Exiting System.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void loadUsers() {
        File file = new File("users.txt");
        if (!file.exists()) {
            System.out.println("Error: users.txt file not found.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] userDetails = scanner.nextLine().split(",");
                if (userDetails.length == 2) {
                    users.put(userDetails[0], userDetails[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public static boolean validateCredentials(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}